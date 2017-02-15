package io.egen.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.api.entity.User;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.EntityNotFoundException;
import io.egen.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	@Transactional
	public User signUp(User user) {
		User existingUser = repository.findbyEmailId(user.getEmailId());
		if (existingUser != null) {
			throw new BadRequestException("User with this email already exists");
		}
		return repository.create(user);
	}
	
	@Override
	@Transactional
	public User signIn(String emailId)
	{
		User existingUser = repository.findbyEmailId(emailId);
		if (existingUser == null) {
			throw new EntityNotFoundException("User with this email does not  exists");
		}
		return existingUser;
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existingUser = repository.findOne(id);
		if (existingUser == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existingUser = repository.findOne(id);
		if (existingUser == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existingUser);
	}

}
