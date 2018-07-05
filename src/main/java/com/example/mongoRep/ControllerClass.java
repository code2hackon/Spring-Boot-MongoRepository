package com.example.mongoRep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

//	@Autowired
//	private  UserRepository userRepository;
//	@Autowired
//	private UserDALImpl userDalImpl;
	
	@Autowired
	private  UserDAL userDal;
	
 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		//return userRepository.findAll();
		return  userDal.getAllUsers();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		//return userRepository.findById(userId).get();
		
		return userDal.getUserById(userId);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		
		//return userRepository.save(user);
		
		return userDal.addNewUser(user);
	}
	
	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
		/*
		User user = userRepository.findById(userId).get();
		if (user != null) {
			return user.getUserSettings();
		} else {
			return "User not found1.";
		}*/
		return userDal.getAllUserSettings(userId);
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		/*User user = userRepository.findById(userId).get();
		if (user != null) {
			return user.getUserSettings().get(key);
		} else {
			return "User not found1.";
		}*/
		
		return userDal.getUserSetting(userId, key);
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		/*User user = userRepository.findById(userId).get();
		if (user != null) {
			user.getUserSettings().put(key, value);
			userRepository.save(user);
			return "Key added";
		} else {
			return "User not found1.";
		}*/
		return userDal.addUserSetting(userId, key, value);
	}
}
