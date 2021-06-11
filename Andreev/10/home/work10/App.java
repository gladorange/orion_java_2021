package homework10;

import homework10.annotation.SecretField;
import homework10.annotation.XmlName;
import homework10.annotation.XmlTypeName;
import homework10.classes.Animal;
import homework10.classes.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class App {

    public String serialize(Collection<?> object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Object el : object){
            final Class<?> aClass = el.getClass();
            String className = getClassName(aClass);
            sb.append("<").append(className).append(">\n");
            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(SecretField.class)) {
                    continue;
                }
                final String fieldName = getFieldName(declaredField);
                declaredField.setAccessible(true);
                sb.append("<")
                        .append(fieldName)
                        .append(">")
                        .append(declaredField.get(el))
                        .append("</")
                        .append(fieldName)
                        .append(">\n");
            }
            sb.append("</")
                    .append(className)
                    .append(">\n");
        }

        return sb.toString();
    }

    private String getFieldName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);

        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    private String getClassName(Class<?> vClass){
        final XmlTypeName annotation = vClass.getAnnotation(XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return vClass.getName();
    }

    public Object deserialize(String sb, Class<?> vClass) throws Exception {
        String[] lines = sb.split("\\n");
        Map<Field,String> map = new HashMap<>();
        String value= "";
        for (int i=0;i<lines.length;i++){
            if (!lines[i].contains(getClassName(vClass))) {
                value = lines[i].substring(lines[i].indexOf(">") + 1, lines[i].indexOf("</"));
            }
            for (Field field : vClass.getDeclaredFields()) {
                String fieldName = getFieldName(field);
                if (lines[i].contains(fieldName)){
                    map.put(field,value);
                }else{
                    if (!map.containsKey(field)) {
                        map.put(field, null);
                    }
                }
            }
        }
        Object obj = vClass.newInstance();
        for (Map.Entry<Field,String> el : map.entrySet()){
            el.getKey().setAccessible(true);
            if (int.class.equals(el.getKey().getType())) {
                el.getKey().setInt(obj, Integer.parseInt(el.getValue()));
            } else if (long.class.equals(el.getKey().getType())) {
                el.getKey().setLong(obj, Long.parseLong(el.getValue()));
            } else if (double.class.equals(el.getKey().getType())) {
                el.getKey().setDouble(obj, Double.parseDouble(el.getValue()));
            } else if (float.class.equals(el.getKey().getType())) {
                el.getKey().setFloat(obj, Float.parseFloat(el.getValue()));
            } else if (short.class.equals(el.getKey().getType())) {
                el.getKey().setShort(obj, Short.parseShort(el.getValue()));
            } else if (byte.class.equals(el.getKey().getType())) {
                el.getKey().setByte(obj, Byte.parseByte(el.getValue()));
            } else if (boolean.class.equals(el.getKey().getType())) {
                el.getKey().setBoolean(obj, Boolean.parseBoolean(el.getValue()));
            } else {
                el.getKey().set(obj, el.getValue());
            }
        }
        return obj;
        }

}
