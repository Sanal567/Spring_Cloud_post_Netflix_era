package com.sanal.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitRestController {

    @Autowired
    private Configuration configuration;

    @RequestMapping("/limit")
    public Limit retrieveLimits() {
        //return new Limit(1, 1000);
        return new Limit(configuration.getMinimum(), configuration.getMaximum());
    }

}
