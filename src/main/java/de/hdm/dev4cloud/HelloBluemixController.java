package de.hdm.dev4cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A sample RESTful Spring controller.
 *
 * @author patrick.kleindienst
 */

@RestController
public class HelloBluemixController {

    @RequestMapping("/")
    public String sayHello() {
        return "Welcome to the lecture 'Software Development for Cloud Computing'.";
    }
}
