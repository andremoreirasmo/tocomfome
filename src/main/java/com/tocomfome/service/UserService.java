package com.tocomfome.service;

import com.tocomfome.bean.User;
import com.tocomfome.generic.GenericService;

public interface UserService extends GenericService<User> {
	boolean authenticate(String email, String password);
	
	User findByEmail(String email);
}
