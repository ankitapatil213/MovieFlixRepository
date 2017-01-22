package io.egen.api.repository;

import io.egen.api.entity.User;

public interface UserRepository {

	public User create(User user);

	public User findbyEmailId(String id);
	public User findOne(String id);
	public User update(User user);

	public void delete(User user);

}
