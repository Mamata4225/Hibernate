package com.xworkz.pizza.service;

import com.xworkz.pizza.dto.PizzaHutDTO;

public class PizzaHutServiceImpl implements PizzaHutService {

	public PizzaHutServiceImpl() {
		System.out.println("invoking PizzaServiceImple ** ");
	}		

	public boolean validPizzaData(PizzaHutDTO pizzHutDTO) {
		System.out.println("inside service imple  validPizzaData()...");

		if (pizzHutDTO.getName() != null && pizzHutDTO.getName().length() >= 4)
//			System.out.println("true");
			return true;
		if (pizzHutDTO.getPrice() != 0)
			return true;
		if (pizzHutDTO.getType() != null && pizzHutDTO.getType().length() >= 2)
			return true;
		if (pizzHutDTO.getLocation() != null && pizzHutDTO.getLocation().length() >= 3)
			return true;

		return true;
	}


}
