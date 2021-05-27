package com.xworkz.pizza.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.pizza.dto.PizzaHutDTO;
import com.xworkz.singlefactory.SingleFactory;

public class PizzaHutDAOImpl implements PizzaHutDAO {

	public void save(PizzaHutDTO pizzaHutdto) {
//		SessionFactory sessionFactory = null;
		Session session = null;
//		Transaction transaction = null;

		try {

//			sessionFactory = new Configuration().configure().buildSessionFactory();
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
			session = sessionFactory.openSession();
			// transaction = session.beginTransaction();
			session.beginTransaction();
			session.save(pizzaHutdto);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
	}

	public void getPizzaHut() {
//		System.out.println("getpizza method");
//		SessionFactory sessionFactory = null;
		Session openSession = null;
		try {
//			sessionFactory = new Configuration().configure().buildSessionFactory();
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
			openSession = sessionFactory.openSession();
			PizzaHutDTO pizzaHutdto = openSession.get(PizzaHutDTO.class, 4);
			System.out.println(pizzaHutdto.toString());

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {
			if (openSession != null) {
				openSession.close();
				System.out.println("Session connection closed");
			} else {
				System.out.println("Session connection not closed");
			}
		}
	}

	public void updatePizzaHut() {
		System.out.println("invoked updatePizzaHut()");
		Session session = null;
		Transaction transaction = null;
		try {
//			sessionFactory = new Configuration().configure().buildSessionFactory();
		    SessionFactory sessionFactory=SingleFactory.getSessionFactory();
			session = sessionFactory.openSession();

			PizzaHutDTO pizzaHutDTO = session.get(PizzaHutDTO.class, 1);
			pizzaHutDTO.setName("vijaynagar");
			pizzaHutDTO.setPrice(499);

			transaction = session.beginTransaction();
			session.update(pizzaHutDTO);
			transaction.commit();
			System.out.println("update is done");

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
	
		}
	}

	public void deletePizzaHut() {

		System.out.println("invoked deletePizza");
		Session session = null;
		Transaction transaction = null;

		try {
			SessionFactory sessionFactory = SingleFactory.getSessionFactory();
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			PizzaHutDTO pizzaHutDTO = session.get(PizzaHutDTO.class, 2);
			transaction = session.beginTransaction();
			session.delete(pizzaHutDTO);
			transaction.commit();
			System.out.println("delete is done");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session connection closed");
			} else {
				System.out.println("Session connection not closed");
			}

		}
	}

	public void loadAllPizzaRecords() {
		System.out.println("invoked loadAllPizzaRecord()");
   SessionFactory sessionFactory=null;
    Session session=null;
    
    try {
		sessionFactory = SingleFactory.getSessionFactory();
		session=sessionFactory.openSession();
//		String hql="select pizza.location from PizzaHutDTO AS pizza where pizzaID=3"; //location
//		String hql="select pizza.price from PizzaHutDTO AS pizza where pizzaID=3"; //price
		String hql="select pizza.location, pizza.name from PizzaHutDTO AS pizza where pizzaID=7";

		Query query = session.createQuery(hql);
        List list=query.list();
//        List <PizzaHutDTO>list=query.list(); // if we have more than one data 

//        for(PizzaHutDTO pizzaHutDTO:list) {
//        	System.out.println(pizzaHutDTO);
//        }
        System.out.println(list);
    
    } catch (Exception e) {
	   e.printStackTrace();
    }
    
    finally {
    	if (session != null) {
			session.close();
			System.out.println("Session connection closed");
		} else {
			System.out.println("Session connection not closed");
		}
	}
	}
}