/**
 * 
 */
package com.sanal.microservices.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sanal567
 *
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);
	
}
