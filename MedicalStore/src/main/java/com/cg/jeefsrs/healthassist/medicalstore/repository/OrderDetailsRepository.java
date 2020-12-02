package com.cg.jeefsrs.healthassist.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;

@Repository
public interface OrderDetailsRepository extends  JpaRepository<Orders, Integer> {

}
