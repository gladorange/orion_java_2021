package framework;

import com.orion.java.homework12.annotations.AfterDependenciesInjected;
import com.orion.java.homework12.annotations.AutowireSimpleComponent;
import com.orion.java.homework12.annotations.SimpleComponent;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleDIFramework {
    String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan)  {
        this.basePackagesToScan = basePackagesToScan;
        try {
            SimpleDIFramework.injectedDependency(  this.basePackagesToScan );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void injectedDependency(String basePackagesToScan) throws IllegalArgumentException,NullPointerException,InstantiationException,IllegalAccessException,InvocationTargetException,NoSuchMethodException {
        if(basePackagesToScan == null){
            throw new IllegalArgumentException("Error: basePackagesToScan can't be null");
        }
        Reflections reflections = new Reflections(basePackagesToScan, new SubTypesScanner(false));

        Set<Class<?>> aClasses = reflections.getSubTypesOf(Object.class);

        Map<Class<?>, Object> objMap = new HashMap<>();

        for (Class<?> el : aClasses) {
            if (el.isAnnotationPresent(SimpleComponent.class)) {
                Object obj = null;
                obj = el.getDeclaredConstructor().newInstance();
                objMap.put(el, obj);
            }
        }
        for (Map.Entry<Class<?>, Object> element : objMap.entrySet()) {

            Class<?> aClass = element.getKey();
            Object value = element.getValue();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutowireSimpleComponent.class)) {

                    if ( field.getType().isAnnotationPresent(SimpleComponent.class) ) {
                        field.setAccessible(true);
                        field.set(value, objMap.get(field.getType()));
                    } else {
                        throw new NullPointerException("Can't find field |" + field.getName() + "| in class |" + aClass.getSimpleName()+"|.");
                    }
                }
            }
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(AfterDependenciesInjected.class)) {
                    method.setAccessible(true);
                    method.invoke(value);
                }
            }
        }
    }


}
