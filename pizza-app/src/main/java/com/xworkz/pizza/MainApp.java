package com.xworkz.pizza;

import com.xworkz.pizza.dao.PizzaHutDAO;
import com.xworkz.pizza.dao.PizzaHutDAOImpl;
import com.xworkz.pizza.dto.PizzaHutDTO;
import com.xworkz.pizza.service.PizzaHutService;
import com.xworkz.pizza.service.PizzaHutServiceImpl;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Program begin");
		PizzaHutDTO pizzaHutDTO = new PizzaHutDTO();

		PizzaHutDAO daoImpl = new PizzaHutDAOImpl();
//		PizzaHutService pizzaServiceImple = new PizzaHutServiceImpl();
//		boolean validPizzaData = pizzaServiceImple.validPizzaData(pizzaHutDTO);
//		if (validPizzaData == true) {
//			daoImpl.save(pizzaHutDTO);
//			System.out.println("inside validate data" + validPizzaData);
//		} else {
//			System.out.println("Please enter valid data");
//		}
//		daoImpl.getPizzaHut();
//		System.out.println("Program end");
//	}
		
        // daoImpl.updatePizzaHut();
       // daoImpl.deletePizzaHut();
	daoImpl.loadAllPizzaRecords();
	
	
	}

}
