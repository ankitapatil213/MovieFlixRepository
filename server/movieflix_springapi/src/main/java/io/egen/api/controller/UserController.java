package io.egen.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.User;
import io.egen.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST)
	public User signUp(@RequestBody User user)
	{
			return service.signUp(user);
	}
	/*@RequestMapping(method = RequestMethod.GET, value = "{uName}")
	public User signIn(@PathVariable("uName"))
	{
		return service.signIn(uName, pwd);
	}*/
	
	@RequestMapping(method = RequestMethod.PUT, value = "{uId}")
	public User updateProfile(@PathVariable("uId") String id, @RequestBody User user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{uId}")
	public void deleteProfile(@PathVariable("uId") String id) {
		service.delete(id);
	}
	
}
