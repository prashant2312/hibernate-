package com.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tute.Student;

public class FirstDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Session s=factory.openSession();
	Student student = s.get(Student.class, 4);
	System.out.println(student);
	
	System.out.println("working on something");
	
	Student student1 = s.get(Student.class, 4);
	
	System.out.println(student1);
	
	boolean contains = s.contains(student1);
	System.out.println(contains);
	factory.close();
	
}
}
