package com.tute;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;

public class FetchDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=factory.openSession();
	
//	Get()
	Student student = session.load(Student.class,1);
	Student student1 = session.load(Student.class,1);
	System.out.println(student);
	
//	Address ad=session.get(Address.class, 1);
//	System.out.println(ad.getStreet());
//	
//	Address ad1=session.get(Address.class, 1);
//	System.out.println(ad1.getStreet());
	
	session.close();
}
}
	