package org.pizzahat.com.demo.controller;

import java.util.List;

import org.pizzahat.com.demo.pojo.Drink;
import org.pizzahat.com.demo.pojo.Pizza;
import org.pizzahat.com.demo.serv.DrinkServ;
import org.pizzahat.com.demo.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/available")
public class ManagerController {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private DrinkServ drinkServ;
	
	@GetMapping
	public String getAllByName(Model model, 
			@RequestParam(name = "query", required = false) String query) {
		
		List<Pizza> pizzas = null;
		List<Drink> drinks = null;
		
		if (query == null || query.isEmpty()) {
			
			pizzas = pizzaServ.findAll();
			drinks = drinkServ.findAll();
		} else {
			
			pizzas = pizzaServ.findByName(query);
			drinks = drinkServ.findByName(query);
		}
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
		
		return "available-search";
	}
}
