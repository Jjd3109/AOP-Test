package com.example.aoptest;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)	// method level annotation
public @interface PerfLog {

    String PageName();
    String ActionName();
    String CRUDType();

}
