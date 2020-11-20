package com.ing.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ing.entities.User;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {
     
	@Query("select u from User u where u.userid = ?#{[0]}")
	User findUser (int userid);

	User save(User user);
}
