package com.ing.service;

import com.ing.entities.User;

public interface UserService {

	User findByUserid(int id);
	User updateUser(int id,User user);
	
}
