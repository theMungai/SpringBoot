package org.theMungai;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstController {

    @GetMapping("/hello")
    public  String sayHello(){
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String post(
           @RequestBody String message   // @RequestBody -> Converts HTTP request body to Java object.
    ){
        return "Request accepted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order   // @RequestBody -> Converts HTTP request body to Java object.
    ){
        return "Request accepted and order is : " + order.toString();
    }

}
