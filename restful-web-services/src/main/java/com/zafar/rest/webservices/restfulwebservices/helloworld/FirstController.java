package com.zafar.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class FirstController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello world");
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {

        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "/hello-bean/{name}")
    public HelloWorldBean helloWorldBeanName(@PathVariable String name) {
        return new HelloWorldBean(String.format("hello world, %s ",name));
    }
}
