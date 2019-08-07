package com.ms.main;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	/* Based on from and to value will fetch details from Database */
	ExchangeValue findByFromAndTo(String from,String to);
}
