package com.lesson12.framework;


import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SimpleDIFramework {

    String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan) throws Exception {
        this.basePackagesToScan = basePackagesToScan;
        makeDI();
    }

    private void makeDI() throws Exception {
        Reflections reflections = new Reflections(basePackagesToScan, new SubTypesScanner(false));
        Set<Class<?>> packageClasses = reflections.getSubTypesOf(Object.class);
        Map<Class<?>, Object> classesForDI = getClassesForDI(packageClasses);
        for (Map.Entry<Class<?>, Object> elem : classesForDI.entrySet()) {
            Class<?> instanceClass = elem.getKey();
            Object instance = elem.getValue();
            fieldsDI(instanceClass, instance, classesForDI);
            invokeAfterDIMethod(instanceClass, instance);
        }
    }

    private Map<Class<?>, Object> getClassesForDI(Set<Class<?>> packageClasses) throws InstantiationException, IllegalAccessException {
        Map<Class<?>, Object> classesForDI = new HashMap<>();
        for (Class<?> targetClass : packageClasses) {
            if (checkClassForDI(targetClass)) {
                Object instance = targetClass.newInstance();
                classesForDI.put(targetClass, instance);
            }
        }
        return classesForDI;
    }

    private void fieldsDI(Class<?> instanceClass, Object instance, Map<Class<?>, Object> classesForDI) throws IllegalAccessException {
        Field[] fields = instanceClass.getDeclaredFields();
        for (Field field : fields) {
            if (checkFieldForDI(field)) {
                if (checkClassForDI(field.getType())) {
                    field.setAccessible(true);
                    field.set(instance, classesForDI.get(field.getType()));

                } else {
                    throw new RuntimeException("Can not DI, then no class for field  "
                            + field.getName() + " in class " + instanceClass.getSimpleName());
                }
            }
        }
    }

    private void invokeAfterDIMethod(Class<?> instanceClass, Object instance) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = instanceClass.getDeclaredMethods();
        for (Method method : methods) {
            if (checkAfterDIMethod(method)) {
                method.setAccessible(true);
                method.invoke(instance);
            }
        }
    }

    private boolean checkClassForDI(Class<?> targetClass) {
        return targetClass.isAnnotationPresent(DIannotations.SimpleComponent.class);
    }

    private boolean checkFieldForDI(Field targetField) {
        return targetField.isAnnotationPresent(DIannotations.AutowireSimpleComponent.class);
    }

    private boolean checkAfterDIMethod(Method targetMethod) {
        return targetMethod.isAnnotationPresent(DIannotations.AfterDependenciesInjected.class);
    }
}
