package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class RedisController {
	private UserRepository userRepository;

	public RedisController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@GetMapping("add/{id}/{name}")
	public User add(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.save(new User(id,name,20000L));
		return userRepository.findById(id);
	}
	@GetMapping("update/{id}/{name}")
	public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.update(new User(id,name,10000L));
		return userRepository.findById(id);
	}
	@GetMapping("/all")
	public Map<String,User> all()
	{
		return userRepository.findAll();
		
	}

}
