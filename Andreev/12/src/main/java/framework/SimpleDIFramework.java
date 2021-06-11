package framework;

import annotation.Annotation;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class SimpleDIFramework {

    String basePackagesToScan;

    public SimpleDIFramework(String basePackagesToScan) throws Exception {
        this.basePackagesToScan = basePackagesToScan;
        doDependencyInjection();
    }

    private void doDependencyInjection() throws Exception {
        Reflections reflections = new Reflections(basePackagesToScan,new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        for (Class<?> el : allClasses){
            if (el.isAnnotationPresent(Annotation.SimpleComponent.class)){
                Method[] methods = el.getDeclaredMethods();
                for (Method method : methods){
                    if (method.isAnnotationPresent(Annotation.AfterDependenciesInjected.class)){
                        Object obj = el.newInstance();
                        Field[] fields = el.getDeclaredFields();
                        for (Field field : fields){
                            if (field.isAnnotationPresent(Annotation.AutowireSimpleComponent.class)){
                                if (checkAutowiredClass(field.getType())){
                                    field.setAccessible(true);
                                    field.set(obj,field.getType().newInstance());
                                }else{
                                    throw new RuntimeException("Отсутствует подходящий класс для поля "
                                    + field.getName() + " в классе " + el.getSimpleName());
                                }
                            }
                        }
                        method.setAccessible(true);
                        method.invoke(obj);
                    }
                }
            }
        }
    }

    private boolean checkAutowiredClass(Class<?> vClass){
        return vClass.isAnnotationPresent(Annotation.SimpleComponent.class);
    }
}
