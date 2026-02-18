package com.theMungai.learning_springboot;


import org.springframework.stereotype.Component;


/* @Component @RestController @Repository @Service -> These are marked down annotations used to mark a class or an object as Spring bean
    [@RestController @Repository @Service ] -> These are special versions of @Component.
    They all mean the same thing -> “Make this class a Bean”
 */


public class MyFirstClass {

    private String myVar;


    public MyFirstClass(String myVar){
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Say hello from MyFirstClass " + myVar;
    }
}