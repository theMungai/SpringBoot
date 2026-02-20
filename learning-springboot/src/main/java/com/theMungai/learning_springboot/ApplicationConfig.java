package com.theMungai.learning_springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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
@Profile("dev") // You can also have a profile annotation at class level
public class ApplicationConfig {

    @Bean("bean1") // This class will be fully managed by the Spring framework
    @Profile("dev") // This bean will only be available for Dev environment only
    //@Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("My first bean");
    }

    @Bean("bean2")
    @Profile("test") // profile annotation on bean level
    //@Qualifier("bean2")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("My second bean");
    }

    @Bean
    @Primary
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("My third bean");
    }
}
