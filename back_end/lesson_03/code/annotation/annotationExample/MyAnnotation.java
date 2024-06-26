package lesson_03.code.annotation.annotationExample;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {
}
