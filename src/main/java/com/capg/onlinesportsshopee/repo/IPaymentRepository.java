
package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Payment;

/*
 * Author : SYED SAMSUDEEN A
 * Version : 1.0
 * Date : 03-04-2021
 * Description : This is Payment Repository 
*/

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	
}

