
package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bean.Payment;


@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	
}

