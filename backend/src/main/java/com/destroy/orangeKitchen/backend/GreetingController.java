package com.destroy.orangeKitchen.backend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

    @GetMapping("/setUser")
    public void setUser(@RequestParam(value = "name", defaultValue = "0") String name) {
        Greeting greeting = new Greeting(1, name);
        System.out.println(greeting.getContent());
    }
}
