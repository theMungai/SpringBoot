package com.theMungai.learning_springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* @Configuration -> Means "This class contains instructions for creating Beans MANUALLY."
* @Bean  -> this tells Spring - "Spring run this method, with these instructions and store it as Bean."
*
*
* @Configuration + @Bean -> these two annotations help you in modifying class.
*
* @Autowired means -> "Spring please find me a bean of this type and give it to me."
* */
@Configuration
public class ApplicationConfig {

    @Bean // This class will be fully managed by the Spring framework
    @Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My first bean");
    }

    @Bean
    @Qualifier("bean2")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My second bean");
    }
}
