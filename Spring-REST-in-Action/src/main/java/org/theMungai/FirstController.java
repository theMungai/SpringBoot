package org.theMungai;


import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order   // @RequestBody -> Converts HTTP request body to Java object.
    ){
        return "Request accepted and order is : " + order.toString();
    }


    // Passing a parameter to a method
    //http://localhost:8080/hello/Mungai
    @GetMapping("/hello/{user-name}")
    public  String pathVar(@PathVariable("user-name") String userName){
        return "How are you " + userName + " ?";
    }

    // Passing request params
    //http://localhost:8080/hello?param_name=paramvalue
    @GetMapping("/hello")
    public  String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastname
    ){
        return "How are you " + userName + " " + userLastname;
    }
}
