package com.sanal.microservices.currencyexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeResource.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable String from,
                                             @PathVariable String to) {

        LOGGER.info("currency exchange service called with {} to {}", from, to);

//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
    	CurrencyExchange currencyExchange = repository.findByFromAndTo("USD", "INR");
    	
    	if(currencyExchange == null)
    		throw new RuntimeException("Unable to find conversion for " + from + " to " + to);
    	
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }

}
