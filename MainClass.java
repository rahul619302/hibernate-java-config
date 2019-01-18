package com.hibernate.practice.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.practice.pojo.Employee;
import com.hibernate.practice.util.HibernateUtil;

public class MainClass {
	
	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(new Employee(0, "Rohan Singh", "Jamshedpur"));
		transaction.commit();
		System.out.println("End");
	}

}
