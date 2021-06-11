package com.lesson10.task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

class ObjectWorkerWithJSON {

    public String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder serialized = new StringBuilder();
        for (Object object : objects) {
            serialized.append(serializeObject(object));
            serialized.append(System.lineSeparator());
        }
        return serialized.toString();
    }

    public <T> List<T> deserialize(String objects, Class<T> targetClass) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        List<T> objectList = new ArrayList<>();
        String[] stringList = objects.split(System.lineSeparator());
        for (String targetString : stringList) {
            objectList.add(deserializeObject(targetClass, targetString));
        }
        return objectList;
    }

    private String serializeObject(Object target) throws IllegalAccessException {
        StringBuilder objectInStrings = new StringBuilder();

        final Class<?> targetClass = target.getClass();
        String className = getClassName(targetClass);
        objectInStrings.append("{")
                .append("\"")
                .append(className)
                .append("\"")
                .append(":")
                .append("{");
        Field[] fields = targetClass.getDeclaredFields();

        for (Field declaredField : fields) {
            if (declaredField.isAnnotationPresent(Annotation.SecretField.class)) {
                continue;
            }
            final String fieldName = getFieldName(declaredField);

            declaredField.setAccessible(true);
            objectInStrings
                    .append("\"")
                    .append(fieldName)
                    .append("\"")
                    .append(":");
            if (declaredField.getType() == String.class) {
                objectInStrings
                        .append("\"")
                        .append(declaredField.get(target))
                        .append("\"");
            } else {
                objectInStrings.append(declaredField.get(target));
            }
            objectInStrings.append(",");
        }
        objectInStrings.deleteCharAt(objectInStrings.length() - 1);
        objectInStrings.append("}}");

        return objectInStrings.toString();
    }

    private <T> T deserializeObject(Class<T> targetClass, String targetString) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        List<String> objectStrings = new ArrayList<>(Arrays.asList(targetString.split(":")));

        objectStrings.remove(0);

        String clearString = String.join(":", objectStrings)
                .replaceAll("\\{", "")
                .replaceAll("}", "")
                .replaceAll("\"", "");

        Map<String, String> objectFields = Arrays.stream(clearString.split(","))
                .collect(Collectors
                        .toMap(elem -> elem.split(":")[0], elem -> elem.split(":")[1]));

        List<Class<?>> argsTypes = new ArrayList<>();
        List<Object> args = new ArrayList<>();
        Field[] fields = targetClass.getDeclaredFields();
        for (Field declaredField : fields) {
            if (declaredField.isAnnotationPresent(Annotation.SecretField.class)) {
                continue;
            }
            String fieldName = getFieldName(declaredField);
            Class<?> fieldType = declaredField.getType();
            argsTypes.add(fieldType);
            if (fieldType == boolean.class) {
                args.add(Boolean.parseBoolean(objectFields.get(fieldName)));
            } else if (fieldType == int.class) {
                args.add(Integer.parseInt(objectFields.get(fieldName)));
            } else if (fieldType == double.class) {
                args.add(Double.parseDouble(objectFields.get(fieldName)));
            } else if (fieldType == String.class) {
                args.add(objectFields.get(fieldName));
            }
        }
        Constructor<T> constructor = targetClass.getConstructor(argsTypes.toArray(Class<?>[]::new));
        return constructor.newInstance(args.toArray(Object[]::new));
    }

    private String getFieldName(Field targetField) {
        final Annotation.JSONname annotation = targetField.getAnnotation(Annotation.JSONname.class);

        if (annotation != null) {
            return annotation.value();
        }
        return targetField.getName();
    }

    private String getClassName(Class<?> targetClass) {
        final Annotation.JSONTypeName annotation = targetClass.getAnnotation(Annotation.JSONTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return targetClass.getName();
    }


}

