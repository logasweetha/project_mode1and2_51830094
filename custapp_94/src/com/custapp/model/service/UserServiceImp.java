package com.custapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.custapp.model.persistance.User;
import com.custapp.model.persistance.UserDao;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String email, String password) {

		return userDao.getUser(email, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public List<User> getAllUser() {

		return userDao.getAllUser();
	}

}
