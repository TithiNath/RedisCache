package com.example.repository;
import java.util.Map;

import com.example.model.User;

public interface UserRepository {
	
	void save(User user);
	Map<String, User> findAll();
	void update(User user);
	void delete(String id);
	public User findById(String id);
}
