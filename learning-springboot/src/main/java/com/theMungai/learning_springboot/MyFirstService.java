package com.theMungai.learning_springboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
// @PropertySource("classpath:custom.properties") -> Single file
@PropertySources({                                // -> Multiple files
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Value("Hello mungai the programmer")
    private String customProperty;

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("123")
    private  Integer customPropertyInt;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }


    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.sayHello();
    }

}
