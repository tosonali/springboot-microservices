package com.ms.main;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*Proxy interface to enable feign client for invoke/talk to other service .
 * name ,URL :Name & URL of service which is going to be consume
 *
 *In method change ExchangeValue with CurrencyConverionBean.
 *In Feign have to give name in PathVariable .
 *Ribbon : Client side load balancer, to distribute load among the instances. 
 * */

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service") 
// Zuul api gateway configuration,now all request will go through Api gateway 
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	/* GET method URI from currency-exchange service */
	/* @GetMapping("/currency-exchange/from/{from}/to/{to}") */
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverionBean  retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
