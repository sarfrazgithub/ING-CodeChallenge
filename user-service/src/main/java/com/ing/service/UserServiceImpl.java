package com.ing.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.entities.User;
import com.ing.exception.UserNotFoundException;
import com.ing.repositories.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User findByUserid(int id) {
		// TODO Auto-generated method stub

		User fromUser = this.userRepo.findUser(id);

		if (fromUser != null) {
			return fromUser;
		}
		throw new UserNotFoundException("User not found with id:" + id);
	}

	@Override
	@Transactional
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		User fromUser = this.userRepo.findUser(id);

		if (fromUser != null) {
			User toUser = fromUser;

			if (user.getAddress() != null) {
				
				 
				if (user.getAddress().getCity() != null) {
					toUser.getAddress().setCity(user.getAddress().getCity());

				}
				if (user.getAddress().getState() != null) {
					toUser.getAddress().setState(user.getAddress().getState());
				}
				if (user.getAddress().getStreet() != null) {
					toUser.getAddress().setStreet(user.getAddress().getStreet());
				}
				if (user.getAddress().getPostcode() != 0) {
					toUser.getAddress().setPostcode(user.getAddress().getPostcode());

				}
				
			}
			if (user.getFirstname() != null) {
				toUser.setFirstname(user.getFirstname());
			}
			if (user.getLastname() != null) {
				toUser.setLastname(user.getLastname());
			}
			if (user.getTitle() != null) {
				toUser.setTitle(user.getTitle());
			}
			if (user.getGender() != null) {
				toUser.setGender(user.getGender());
			}

			userRepo.save(toUser);
			return toUser;

		} else {
			throw new UserNotFoundException("User not found with id:" + id);
		}
	}

}
