package com.dcs.order.query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailView, String>{
	public List<OrderDetailView> findByOrderId(String orderId);
}
