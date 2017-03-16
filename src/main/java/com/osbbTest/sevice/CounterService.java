package com.osbbTest.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbbTest.dao.CounterDao;
import com.osbbTest.model.Counter;


@Service(value = "counterService")
@Transactional
public class CounterService {
	
	@Autowired
	private CounterDao counterDao;
	
	public Counter getCounterById(Long id) {
		return counterDao.getCounterById(id);
	}
	public void updateCounter(Long id, Double amount) {
		 Counter counter = counterDao.getCounterById(id);
		 counter.setAmount(amount);
		 counterDao.update(counter);
	}
	public Double toPay(Long id, Double amount){
		 Counter counter = counterDao.getCounterById(id);
		 Double payment = (amount - counter.getAmount())*counter.getServiceType().getRate();
		 return payment;
	}
}
