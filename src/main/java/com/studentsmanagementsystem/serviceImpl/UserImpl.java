package com.studentsmanagementsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsmanagementsystem.entity.User_Pass;
import com.studentsmanagementsystem.repository.user_repo;
import com.studentsmanagementsystem.service.UserService;

@Service
public class UserImpl implements UserService {
	
	@Autowired
	user_repo userrepo;

	public List<User_Pass> getAllUser() 
	{

		List<User_Pass> user = userrepo.findAll();
		return user;

	}

}
