package co.develhope.Middleware2.InterceptorMiddleware02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }
}