package org.pizzahat.com.demo.serv;

import java.util.List;

import org.pizzahat.com.demo.pojo.Drink;
import org.pizzahat.com.demo.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkServ {

	@Autowired
	private DrinkRepo drinkRepo;
	
	public void save(Drink drink) {
		
		drinkRepo.save(drink);
	}
	public void delete(Drink drink) {
		
		drinkRepo.delete(drink);
	}
	public List<Drink> findAll() {
		
		return drinkRepo.findAll();
	}
}
