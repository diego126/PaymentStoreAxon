package com.dcs.order.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, String>{
	
}
