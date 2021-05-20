package com.xworkz.pizza;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.pizza.dto.PizzaHutDTO;

public class MainApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		PizzaHutDTO pizzaHutdto = new PizzaHutDTO("corn pizza", "Rajajinagar", 399, true, "large", "veg");
		Transaction transaction = session.beginTransaction();
		session.save(pizzaHutdto);
		transaction.commit();
	}

}
