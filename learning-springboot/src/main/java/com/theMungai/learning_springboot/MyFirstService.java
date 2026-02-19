package com.theMungai.learning_springboot;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${spring.application.name}")
    private String customProperty;

    @Value("${custom.property}")
    private Integer customPropertyInt;

    public String getCustomProperty(){
        return customProperty;
    }

    public Integer getCustomPropertyInt(){
        return customPropertyInt;
    }

    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.sayHello();
    }

}
