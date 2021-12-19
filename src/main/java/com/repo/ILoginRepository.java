package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Login;
import com.bean.User;



// Description : This is Login Repository Class

@Repository
public interface ILoginRepository extends JpaRepository<Login, User> {


}