package home.work10;

import homework10.annotation.Annotation;

import java.lang.reflect.Field;
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
                if (declaredField.isAnnotationPresent(Annotation.SecretField.class)) {
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
        final Annotation.XmlName annotation = declaredField.getAnnotation(Annotation.XmlName.class);

        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    private String getClassName(Class<?> vClass){
        final Annotation.XmlTypeName annotation = vClass.getAnnotation(Annotation.XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return vClass.getName();
    }

    public String deserialize(String sb, Class<?> vClass)  {
        String[] lines = sb.split("\\n");
        StringBuilder sBuilder = new StringBuilder();
        Map<String,String> obj = new HashMap<>();
        String value= "";
        for (int i=0;i<lines.length;i++){
            if (!lines[i].contains(getClassName(vClass))) {
                value = lines[i].substring(lines[i].indexOf(">") + 1, lines[i].indexOf("</"));
            }
            for (Field field : vClass.getDeclaredFields()) {
                String fieldName = getFieldName(field);
                if (lines[i].contains(fieldName)){
                    obj.put(fieldName,value);
                }else{
                    if (!obj.containsKey(fieldName)) {
                        obj.put(fieldName, "null");
                    }
                }
            }
        }
        sBuilder.append(vClass.getSimpleName()).append("{");
        obj.forEach((key,val) -> sBuilder.append(key).append("=").append(val).append(","));
        sBuilder.deleteCharAt( sBuilder.length() - 1 );
        sBuilder.append("}");
        return sBuilder.toString();
        }

}
