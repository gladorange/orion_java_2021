package com.task10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public interface Serializer {
    String serialize(Collection<?> serializingCollection);
    <T> List<T> deserialize(String serializedCollection, Class<T> targetClass);

    default String getClassTypename(Class<?> c) {
        final Typename typenameAnn = c.getAnnotation(Typename.class);
        if (typenameAnn != null)
            return typenameAnn.value();
        return c.getSimpleName();
    }

    default String getFieldName(Field f) {
        final Name nameAnn = f.getAnnotation(Name.class);
        if (nameAnn != null)
            return nameAnn.value();
        return f.getName();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Ignore { }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Name {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Typename {
        String value() default "";
    }
}
