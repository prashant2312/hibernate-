package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.Certificate;
import com.tute.Student;

public class StateDemo {
public static void main(String[] args) {
	System.out.println("Example");
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
//	Creating student object]
	Student student=new Student();
	student.setId(1414);
	student.setName("Game");
	student.setCity("PQR");
	student.setCerti(new Certificate("Java course","2 month"));
//	Transient state
	
	
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	session.save(student);
//	Persistent state on database
	student.setName("Peter");
	
	tx.commit();
	
	session.close();
	
	
//	detached
	student.setName("Sachin");
	
	factory.close();
}
}
