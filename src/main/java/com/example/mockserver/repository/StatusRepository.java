package com.example.mockserver.repository;

import com.example.mockserver.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusRepository extends JpaRepository<Status, Long> {

    /*@Query("select * from STATUS where product_order_id = ?1")
    Status findByProductOrderId(String productOrderId);*/
}
