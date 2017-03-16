package com.osbbTest.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.osbbTest.model.Counter;
import com.osbbTest.model.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractCrudDao<User> implements UserDao {
	

	@Override
	public List<User> getAll() {
		 Query query = getCurrentSession().createQuery("select a FROM User a");
	        return (List<User>) query.getResultList();
			
	}

	@Override
	public User getById(Long id) {
		Query query = getCurrentSession().createQuery("FROM User WHERE id=:id");
		query.setParameter("id", id);		
		return (User) query.getSingleResult();
	}

	@Override
	public User getUserByEmail(String email) {
		 Query<User> query = getCurrentSession().createQuery("from User u where u.email = :email");
	        query.setParameter("email", email);
	        return  (User) query.getSingleResult();
	}

	@Override
	public List<User> getAllByHouseId(Long id) {
		 Query query = getCurrentSession().createQuery("select a FROM User a join houses_users h on h.users_id=a.id where h.house_id=:id");
		 query.setParameter("id", id);		
	        return (List<User>) query.getResultList();
	}
	
	
}
