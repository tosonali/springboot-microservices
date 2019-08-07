package com.ms.main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	
	
	/* Using Feign client */
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		/* Calling feign proxy */		
		CurrencyConverionBean response = proxy.retrieveExchangeValue(from, to);
		
		logger.info("{}",response);
		
		return new CurrencyConverionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()),response.getPort()) ;
	}
	
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverionBean convertCurrency(@PathVariable String from ,
			@PathVariable String to ,
			@PathVariable BigDecimal quantity) {
		
		/* RestTemplate :Access currency-exchange service to get total calculation of currency using RESTTemplate.
		 * UriVariables :uriVariables want to take from GET_REQUEST,So all variables need to add in a MAP and pass map in restTemplate 
		 * Response_type :CurrencyConverionBean.class 
		 * */
		
		//Feign : Problem-1
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConverionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConverionBean.class, uriVariables);
		// Getting CurrencyConverionBean from response body. 
		CurrencyConverionBean response = responseEntity.getBody();
		
		logger.info("{}",response);
		
		return new CurrencyConverionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()),response.getPort()) ;
	}

}
