package org.pizzahat.com.demo;

import java.util.List;

import org.pizzahat.com.demo.pojo.Drink;
import org.pizzahat.com.demo.pojo.Pizza;
import org.pizzahat.com.demo.serv.DrinkServ;
import org.pizzahat.com.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private DrinkServ drinkServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", null, 1000);
		Pizza p2 = new Pizza("Margherita piccante", "my p2 desc", 2200);
		Pizza p3 = new Pizza("Diavola", "my p3 desc", 400);
		Pizza p4 = new Pizza("Diavola light", null, 1200);
	
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
		
//		List<Pizza> pizzas = pizzaServ.findAll();
//		System.out.println(pizzas);
		
		Drink d1 = new Drink("Gin tonic", "desc drink 1", 10000);
		Drink d2 = new Drink("Vodka tonic", "desc drink 2", 12000);
		Drink d3 = new Drink("Gin lemon", "desc drink 3", 1000);
		Drink d4 = new Drink("Vodka lemon", "desc drink 4", 20000);
		
		drinkServ.save(d1);
		drinkServ.save(d2);
		drinkServ.save(d3);
		drinkServ.save(d4);
		
		List<Drink> drinks = drinkServ.findAll();
		System.out.println(drinks);
	}
}
