package com.szl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebRoute {

    enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    HttpMethod method() default HttpMethod.GET;
    String path() default "/";

}
