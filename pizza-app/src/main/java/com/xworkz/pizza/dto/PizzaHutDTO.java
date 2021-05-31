package com.xworkz.pizza.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="pizza_table")
@NamedQueries({@NamedQuery(name="getAllRecords", query="from PizzaHutDTO"),
@NamedQuery(name="getPriceByName", query = "select p.price from PizzaHutDTO AS p where p.name=:pizzaname"),
@NamedQuery(name="loadFirstResultAndMaxResult", query="from PizzaHutDTO"),
@NamedQuery(name="sumOfAllPizza", query="select sum(price) from PizzaHutDTO"),
@NamedQuery(name="getMaxPriceOfPizza", query="select max(price) from PizzaHutDTO")})

public class PizzaHutDTO implements java.io.Serializable{

	@Column(name="PIZZA_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pizzaID;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="PRICE")
	private double price;

	@Column(name="IS_AVAILABLE")
	private boolean isAvailable;
	
	@Column(name="SIZE")
	private String size;
	
	@Column(name="TYPE")
	private String type;
	
	public PizzaHutDTO() {
		System.out.println(this.getClass().getSimpleName()+"object created");
	}
	public PizzaHutDTO(	String name, String location, double price,
			 boolean isAvailable,  String size,  String type) {
		super();
		this.name = name;
		this.location = location;
		this.price = price;
		this.isAvailable = isAvailable;
		this.size = size;
		this.type = type;
		
		System.out.println(this.getClass().getSimpleName()+"object created");
		}
	@Override
	public String toString() {
		return "PizzaHutDTO [pizzaID=" + pizzaID + ", name=" + name + ", location=" + location + ", price=" + price
				+ ", isAvailable=" + isAvailable + ", size=" + size + ", type=" + type + "]";
	}
}
