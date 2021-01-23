package com.example.mockserver.repository;

import com.example.mockserver.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select s from Status s where s.productOrderId = :productOrderId")//ProductOrderId
    Status findByProductOrderId(@Param("productOrderId") String productOrderId);
}
