package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import io.egen.api.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}
	public User findbyEmailId(String emailId)
    {
		TypedQuery<User> query = em.createNamedQuery("User.findByemailId", User.class);
		query.setParameter("emailId", emailId);

		List<User> user = query.getResultList();
		if (user != null && user.size() == 1) {
			return user.get(0);
		} else {
			return null;
		}
	}
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

}
