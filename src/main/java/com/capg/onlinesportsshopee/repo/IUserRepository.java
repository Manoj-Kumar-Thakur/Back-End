
package com.capg.onlinesportsshopee.repo;

import com.capg.onlinesportsshopee.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/*
 * Author : SAI MADHU BHAVANA A
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is User Repository 
*/

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

	

	
	/*
	 * public User addUser(User user); public User getId(long userID); public User
	 * updateUser(User user); public User deleteUser(long userID); public UserDTO
	 * getusername(User user);
	 */
	
}




