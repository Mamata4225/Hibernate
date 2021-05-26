package com.xworkz.pizza.dao;

import com.xworkz.pizza.dto.PizzaHutDTO;

public interface PizzaHutDAO {

	public void save(PizzaHutDTO pizzaHutdto);

	public void getPizzaHut();

	public void updatePizzaHut();

	public void deletePizzaHut();

}
