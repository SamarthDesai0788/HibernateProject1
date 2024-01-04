package com.java.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.entity.Employee;

public class EmployeeConfigure {
	public static void main(String[] args) {
		Configuration config = new Configuration();

		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Transaction tc = session.beginTransaction();
//		Employee e1 = new Employee();
//		e1.setId(26);
//		e1.setName("samarth");
//		e1.setSalary(45000);
//		session.save(e1);
//		tc.commit();

//	Employee e1=session.find(Employee.class, 21);
//	e1.setName("Samarth");
//	session.update(e1);
//	session.beginTransaction().commit();
////		
//		Employee e1=session.find(Employee.class, 26);
//		System.out.println("ID :"+e1.getId());
//		System.out.println("Name :"+e1.getName());
//		System.out.println("Salary :"+e1.getSalary());
//		
//		session.beginTransaction().commit();
		
		//String sqlQuery = "SELECT * FROM Employee";

		List<Object[]> resultList = session.createNativeQuery("SELECT * FROM Employee WHERE id=26;").getResultList();

		for (Object[] row : resultList) {
		    int id = (int) row[0];	
		    int salary = (int) row[1];
		    String name = (String) row[2];
		
		    System.out.println("ID: " + id);    
		    System.out.println("Salary: " + salary);
		    System.out.println("Name: " + name);   
		}
		session.close();

	}
}	
