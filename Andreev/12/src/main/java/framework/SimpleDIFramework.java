package framework;

import annotation.AfterDependenciesInjected;
import annotation.AutowireSimpleComponent;
import annotation.SimpleComponent;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class SimpleDIFramework {

    String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan) throws Exception {
        this.basePackagesToScan = basePackagesToScan;
        doDependencyInjection();
    }

    private void doDependencyInjection() throws Exception {
        Reflections reflections = new Reflections(basePackagesToScan, new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        Map<Class<?>, Object> objMap = new HashMap<>();
        for (Class<?> el : allClasses) {
            if (el.isAnnotationPresent(SimpleComponent.class)) {
                Object obj = el.newInstance();
                objMap.put(el, obj);
            }
        }
        for (Map.Entry<Class<?>, Object> element : objMap.entrySet()) {
            Class<?> key = element.getKey();
            Object value = element.getValue();
            Field[] fields = key.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutowireSimpleComponent.class)) {
                    if (checkAutowiredClass(field.getType())) {
                        field.setAccessible(true);
                        field.set(value, objMap.get(field.getType()));

                    } else {
                        throw new RuntimeException("Отсутствует подходящий класс для поля "
                                + field.getName() + " в классе " + key.getSimpleName());
                    }
                }
            }
            Method[] methods = key.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(AfterDependenciesInjected.class)) {
                    method.setAccessible(true);
                    method.invoke(value);
                }
            }
        }
    }

    private boolean checkAutowiredClass(Class<?> vClass) {
        return vClass.isAnnotationPresent(SimpleComponent.class);
    }
}
