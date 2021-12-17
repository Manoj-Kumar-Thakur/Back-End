package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Login;
import com.capg.onlinesportsshopee.bean.User;


/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 06-04-2021
 * Description : This is Login Repository Class
*/
@Repository
public interface ILoginRepository extends JpaRepository<Login, User> {


}