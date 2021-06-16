package com.task12.core;

import com.task12.core.annotation.AfterDependenciesInjected;
import com.task12.core.annotation.AutowireSimpleComponent;
import com.task12.core.annotation.SimpleComponent;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class SimpleDIFramework {

    private final String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan) {
        this.basePackagesToScan = basePackagesToScan;
        try {
            resolveDependencies();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void resolveDependencies()
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Разрешаю зависимости для пакета \"" + basePackagesToScan + "\":");
        System.out.println();

        Reflections reflections = new Reflections(basePackagesToScan);
        Map<Class<?>, Object> simpleComponents = new HashMap<>();

        for (Class<?> simpleCompClass : reflections.getTypesAnnotatedWith(SimpleComponent.class)) {
            try {
                Constructor<?> constructor = simpleCompClass.getConstructor();
                simpleComponents.put(simpleCompClass, constructor.newInstance());
            } catch (NoSuchMethodException e) {
                System.out.println("Для класса " + simpleCompClass.getSimpleName() + " не найден конструктор без аргументов - пропускаю");
            }
        }
        System.out.println("  Созданы объекты:");
        for (Map.Entry<Class<?>, Object> entry : simpleComponents.entrySet()) {
            System.out.println("  - " + entry.getValue().toString());
        }

        System.out.println();
        for (Map.Entry<Class<?>, Object> entry : simpleComponents.entrySet()) {
            Object component = entry.getValue();

            Set<Field> autowiredFields = ReflectionUtils.getAllFields(component.getClass(),
                    ReflectionUtils.<Field>withAnnotation(AutowireSimpleComponent.class));
            if (!autowiredFields.isEmpty()) {
                System.out.println("  Для " + component.toString() + ":");
                for (Field field : autowiredFields) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    field.set(component, simpleComponents.get(fieldType));
                    System.out.println("    Полю \"" + field.getName() + "\" присвоено значение \"" + field.get(component) + "\"");
                }
            }

            Set<Method> afterDIMethods = ReflectionUtils.getAllMethods(component.getClass(),
                    ReflectionUtils.<Method>withAnnotation(AfterDependenciesInjected.class));
            if (!afterDIMethods.isEmpty()) {
                for (Method method : afterDIMethods) {
                    method.setAccessible(true);
                    method.invoke(component);
                    System.out.println("    Вызван метод \"" + method.getName() + "\"");
                }
            }

            System.out.println();
        }
        System.out.println("Зависимости для пакета \"" + basePackagesToScan + "\" разрешены");
    }

}
