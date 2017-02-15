package io.egen.api.service;

import org.springframework.web.bind.annotation.RequestBody;

import io.egen.api.entity.User;

public interface UserService
{
	public User signUp(@RequestBody User user);
	public User signIn(String emailId);
	public User update(String id, User user);
	public void delete(String emailId);

}
