package com.example.repository;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{


	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;
		
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
		
	}

	@Override
	public Map<String,User> findAll() {
		
		return hashOperations.entries("USER");
	}

	@Override
	public void update(User user) {
		save(user);
		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
		
	}

	@Override
	public User findById(String id) {
		
		return (User)hashOperations.get("USER", id);
	}

}
