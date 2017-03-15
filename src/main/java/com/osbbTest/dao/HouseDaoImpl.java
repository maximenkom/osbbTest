package com.osbbTest.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.osbbTest.model.House;
import com.osbbTest.model.User;


@Repository("houseDao")
public class HouseDaoImpl  extends AbstractCrudDao<House> implements HouseDao {

	@Override
	public List<House> getAll() {
		 Query query = getCurrentSession().createQuery("select a FROM House a");
	        return (List<House>) query.getResultList();
	}

	@Override
	public House getById(Long id) {
		 Query query = getCurrentSession().createQuery("select u FROM House u WHERE u.id=:id");
		 query.setParameter("id", id);
	        return (House) query.getSingleResult();
	}

	@Override
	public House getHouseByUserId(Long usersId) {
		 //Query query = getCurrentSession().createQuery("select u FROM User");// join  WHERE users_id=:id");		
		 Query query = getCurrentSession().createQuery("select h FROM House h where id=1");
		 //query.setParameter("id", usersId);
		 System.out.println((Long) query.getSingleResult());
		return (House) query.getSingleResult();
	}

}
