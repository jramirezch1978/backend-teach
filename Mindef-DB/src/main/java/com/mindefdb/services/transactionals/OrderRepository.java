package com.mindefdb.services.transactionals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindefdb.services.transactionals.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
