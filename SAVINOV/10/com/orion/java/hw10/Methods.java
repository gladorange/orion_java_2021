package com.orion.java.hw10;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Methods {

    public static String serialize(Object... objects) throws IllegalAccessException {
        StringBuilder totalSB = new StringBuilder();
        for (Object object : objects) {
            Class<?> aClass = object.getClass();
            StringBuilder sb = new StringBuilder("<" + aClass.getSimpleName() + ">\n");

            for (Field field : aClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(MyAnnotation.XmlIgnore.class)) {
                    continue;
                }
                field.setAccessible(true);
                String fieldName = getName(field);
                sb.append("   <" + fieldName + ">" + field.get(object) + "</" + fieldName + ">\n");
            }
            sb.append("</" + aClass.getSimpleName() + ">\n");
            totalSB.append(sb);
        }
        return totalSB.toString();
    }

    private static String getName(Field field) {
        MyAnnotation.XmlName annotation = field.getAnnotation(MyAnnotation.XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return field.getName();
    }

    public static <T> T deserialize(String inputString, Class<T> targetClass) throws InstantiationException, IllegalAccessException {
        String[] arrayInputStrings = inputString.split("\n");
        List<String> targetClassFieldsList = getTargetClassFieldsList(targetClass, arrayInputStrings);
        Map<String, String> collect = targetClassFieldsList.stream().collect(Collectors.toMap(el -> el.split(">")[0], el -> el.split(">")[1]));
        T object = createObject(targetClass, collect);
        return object;
    }

    private static <T> List<String> getTargetClassFieldsList(Class<T> targetClass, String[] arrayInputStrings) {
        List<String> targetClassFieldsList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < arrayInputStrings.length; i++) {
            if (arrayInputStrings[i].equals("</" + targetClass.getSimpleName() + ">")) {
                break;
            }
            if (flag) {
                targetClassFieldsList.add(arrayInputStrings[i].split("<")[1]);
            }
            if (arrayInputStrings[i].equals("<" + targetClass.getSimpleName() + ">")) {
                flag = true;
            }
        }
        return targetClassFieldsList;
    }

    private static <T> T createObject(Class<T> targetClass, Map<String, String> collect) throws InstantiationException, IllegalAccessException {
        T object = targetClass.newInstance();
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = getName(field);
            field.setAccessible(true);

            if (field.getType() == String.class) {
                field.set(object, collect.get(fieldName));
            } else if (field.getType() == Boolean.class) {
                field.set(object, Boolean.parseBoolean(collect.get(fieldName)));
            } else if (field.getType() == Integer.class) {
                field.set(object, Integer.parseInt(collect.get(fieldName)));
            } else if (field.getType() == Double.class) {
                field.set(object, Double.parseDouble(collect.get(fieldName)));
            }
        }
        return object;
    }
}
