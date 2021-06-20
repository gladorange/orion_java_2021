package Task;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlSerializer
{
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface XmlName
    {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface XmlIgnore
    {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface XmlTypeName
    {
        String value() default "";
    }

    private static String getClassName(Class<?> cls)
    {
        final XmlTypeName annotation = cls.getAnnotation(XmlTypeName.class);
        if (annotation != null)
        {
            return annotation.value();
        }
        return cls.getSimpleName();
    }

    private static String getName(Field declaredField)
    {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null)
        {
            return annotation.value();
        }
        return declaredField.getName();
    }

    public static String serialize(Collection<?> objects) throws IllegalAccessException
    {
        StringBuilder sb = new StringBuilder();
        for (Object object : objects)
        {
            final Class<?> cls = object.getClass();
            final String objectName = getClassName(cls);
            sb.append("<").append(objectName).append(">\n");

            for (Field field : cls.getDeclaredFields())
            {
                if (field.isAnnotationPresent(XmlIgnore.class))
                {
                    continue;
                }

                final String fieldName = getName(field);
                field.setAccessible(true);
                if (field.getType().isAssignableFrom(double.class)
                        || field.getType().isAssignableFrom(int.class)
                        || field.getType().isAssignableFrom(boolean.class)
                        || field.getType().isAssignableFrom(String.class))
                {
                    sb.append("\t<").append(fieldName).append(">");
                    sb.append(field.get(object).toString());
                    sb.append("</").append(fieldName).append(">\n");
                }
            }

            sb.append("</").append(objectName).append(">\n");
        }
        return sb.toString();
    }

    public static Object getObjectWithInitFields(Map.Entry<String, Map<String, String>> classWithFieldValues, Class<?> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        Map<String, String> values = classWithFieldValues.getValue();
        Object result = cls.getDeclaredConstructor().newInstance();
        for (Field field : cls.getDeclaredFields())
        {
            if (field.isAnnotationPresent(XmlIgnore.class))
            {
                continue;
            }

            field.setAccessible(true);
            if (field.getType().isAssignableFrom(double.class))
            {
                field.setDouble(result, Double.parseDouble(values.get(getName(field))));
            }
            else if (field.getType().isAssignableFrom(int.class))
            {
                field.setInt(result, Integer.parseInt(values.get(getName(field))));
            }
            else if (field.getType().isAssignableFrom(boolean.class))
            {
                field.setBoolean(result, Boolean.parseBoolean(values.get(getName(field))));
            }
            else
            {
                field.set(result, values.get(getName(field)));
            }
        }
        return result;
    }

    public static List<Object> deserialize(String xml, Class<?> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        Stack<String> stack = new Stack<>();
        Map<String, String> fieldsValues = new HashMap<>();
        List<Map.Entry<String, Map<String, String>>> classesWithFieldValues = new ArrayList<>();
        final String[] strings = xml.split("\n");
        for (String str : strings)
        {
            Matcher m = Pattern.compile("</|<").matcher(str);
            int firstIndex = m.find() ? m.end() : -1;
            int nextIndex = str.indexOf(">");
            String xmlName = str.substring(firstIndex, nextIndex);
            if (stack.contains(xmlName))
            {
                while (!stack.pop().equals(xmlName));
                classesWithFieldValues.add(new AbstractMap.SimpleEntry<>(xmlName, new HashMap<>(fieldsValues)));
                fieldsValues.clear();
                continue;
            }
            stack.push(xmlName);

            if (str.contains("</" + xmlName + ">"))
            {
                fieldsValues.put(xmlName, str.substring(nextIndex + 1, str.lastIndexOf("</")));
            }
        }

        List<Object> results = new ArrayList<>();
        final String className = getClassName(cls);
        for (var classWithFieldValues : classesWithFieldValues)
        {
            if (!classWithFieldValues.getKey().equals(className))
            {
                continue;
            }

            Object result = getObjectWithInitFields(classWithFieldValues, cls);
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException
    {
        Person person = new Person("Петя", 15, "PetyaPetya");
        Person person1 = new Person("Ваня", 21, "Vano21");
        Animal animal = new Animal("Пуся", "Катунки", 8);

        List<Object> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(animal);

        final String serializeResult = serialize(personList);
        System.out.println(serializeResult);

        List<Object> resultsPerson = deserialize(serializeResult, Person.class);
        resultsPerson.forEach(System.out::println);
        List<Object> results = deserialize(serializeResult, Animal.class);
        results.forEach(System.out::println);
    }
}
