package com.sanal.microservices.currencyexchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name ="default", fallbackMethod = "hardCodedResponse")
    @RateLimiter(name="default")
    public String sampleApi(){
        LOGGER.info("sample API");
//    ResponseEntity<String> responseEntity  = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//    return responseEntity.getBody();
        return "sample API";
}

public String hardCodedResponse(Exception exception){
        return "fallback-response";
}

}
