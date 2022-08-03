package cn.ray.design.agent;

import java.lang.annotation.*;

/**
 * @author JOJO
 * @date 2022/8/3 21:39
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String value() default "";

}
