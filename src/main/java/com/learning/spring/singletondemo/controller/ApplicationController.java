package com.learning.spring.singletondemo.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@Configuration
public class ApplicationController {

    @Autowired
    @Qualifier("numberCollectorSingleton")
    private NumberCollector numberCollectorSingleton;

    @Autowired
    @Qualifier("numberCollectorPrototype")
    private ObjectFactory<NumberCollector> numberCollectorPrototype;

    @Autowired
    @Qualifier("numberCollectorRequest")
    private NumberCollector numberCollectorRequest;

    @GetMapping("/singleton")
    public List<String> getSingletonList() {
        numberCollectorSingleton.add("Singleton");
        return numberCollectorSingleton.getList();
    }

    @GetMapping("/prototype")
    public List<String> getPrototypeList() {
        NumberCollector numberCollector = numberCollectorPrototype.getObject();
        numberCollector.add("Prototype");
        return numberCollector.getList();
    }

    @GetMapping("/request")
    public List<String> getRequestList() {
        numberCollectorRequest.add("Request");
        return numberCollectorRequest.getList();
    }

    @Bean
    @Scope("singleton")
    public NumberCollector numberCollectorSingleton() {
        return new NumberCollector();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public NumberCollector numberCollectorRequest() {
        return new NumberCollector();
    }

    @Bean
    @Scope("prototype")
    public NumberCollector numberCollectorPrototype() {
        return new NumberCollector();
    }

}
