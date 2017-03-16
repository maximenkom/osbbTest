package com.osbbTest.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.osbbTest.model.Counter;
import com.osbbTest.model.User;

@Repository("counterDao")
public class CounterDaoImpl  extends AbstractCrudDao<Counter> implements CounterDao {

	@Override	
	public List<Counter> getCountersByUsersId(Long id) {
		 Query query = getCurrentSession().createQuery("FROM Counter where user_id=:id order by servicename");
		 query.setParameter("id", id);		
	        return (List<Counter>) query.getResultList();
	}

	@Override
	public Counter getCounterById(Long id) {
		Query query = getCurrentSession().createQuery("FROM Counter WHERE id=:id");
		query.setParameter("id", id);		
		return (Counter) query.getSingleResult();
	}
	
}
