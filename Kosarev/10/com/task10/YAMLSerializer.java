package com.task10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;


public class YAMLSerializer implements Serializer {
    private static final String INDENT_STR          = "    ";
    private static final String OBJ_DELIMITER_STR   = "---\n";
    private static int indentLevel = 0;

    @Override
    public String serialize(Collection<?> objToSerialize) {
        StringBuilder serialized = new StringBuilder();

        for (Object obj : objToSerialize) {
            Class<?> objClass = obj.getClass();
            serialized.append(INDENT_STR.repeat(indentLevel))
                      .append(getClassTypename(objClass))
                      .append(":\n");
            indentLevel++;

            for (Field field : objClass.getDeclaredFields()) {
                if ( field.isAnnotationPresent(Serializer.Ignore.class) ) {
                    continue;
                }

                try {
                    field.setAccessible(true);
                    serialized.append(INDENT_STR.repeat(indentLevel))
                            .append(getFieldName(field))
                            .append(": ")
                            .append(field.get(obj).toString())
                            .append('\n');
                } catch (IllegalAccessException ignored) {
                }
            }

            indentLevel--;
            serialized.append(INDENT_STR.repeat(indentLevel))
                      .append(OBJ_DELIMITER_STR);
        }

        return serialized.toString();
    }

    @Override
    public <T> List<T> deserialize(String serializedCollection, Class<T> targetClass) {
        List<T> deserializedObjects = new ArrayList<>();

        for (String serializedObj : serializedCollection.split(OBJ_DELIMITER_STR)) {
            List<String> argPairs = Arrays.asList(serializedObj.split("\n" + INDENT_STR));
            String[] argValuesStr = argPairs.subList(1, argPairs.size())
                    .stream()
                    .map(s -> s.split(": ")[1]
                            .replaceAll("\n", ""))
                    .toArray(String[]::new);

            Class<?>[] argTypes = Arrays.stream(argValuesStr)
                    .map(Utils::getType)
                    .toArray(Class[]::new);

//            System.out.println("Gonna search constructor with args: " + Arrays.toString(argTypes));
            Constructor<T> constructor;
            try {
                constructor = targetClass.getConstructor(argTypes);
                Object[] args = Arrays.stream(argValuesStr).map(s -> {
                    Class<?> type = Utils.getType(s);
                    if (type == double.class) {
                        return Double.parseDouble(s);
                    } else if (type == int.class) {
                        return Integer.parseInt(s);
                    } else if (type == boolean.class) {
                        return Boolean.parseBoolean(s);
                    } else {
                        return s;
                    }
                }).toArray();
                T newInstance = constructor.newInstance(args);
                deserializedObjects.add(newInstance);
            } catch (NoSuchMethodException e) {
                System.out.println("Constructor not found");
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return deserializedObjects;
    }

    static class Utils {
        private static final Pattern IS_BOOLEAN_PATTERN    = Pattern.compile("true|false$");
        private static final Pattern IS_INTEGER_PATTERN    = Pattern.compile("^\\d+$");
        private static final Pattern IS_DOUBLE_PATTERN     = Pattern.compile("^\\d+.\\d+$");

        public static Class<?> getType(String str) {
            if (isType(str, IS_BOOLEAN_PATTERN))
                return boolean.class;
            else if (isType(str, IS_INTEGER_PATTERN))
                return int.class;
            else if (isType(str, IS_DOUBLE_PATTERN))
                return double.class;
            else
                return String.class;
        }

        private static boolean isType(String str, Pattern type) {
            return type.matcher(str).matches();
        }
    }

}
