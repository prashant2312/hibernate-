package com.tute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=factory.openSession();
	
	Student student1=new Student();
	student1.setId(100);
	student1.setName("Ankit tiwari");
	student1.setCity("Nbd");
	
	Student student2=new Student();
	student2.setId(100);
	student2.setName("Ankit tiwari");
	student2.setCity("Nbd");
	
	Certificate certi=new Certificate();
	certi.setCourse("Android");
	certi.setDuration("2 month");
	
	Certificate certi1=new Certificate();
	certi1.setCourse("Hibernate");
	certi1.setDuration("1.5 month");
	
	student1.setCerti(certi);
	student2.setCerti(certi1);
	
	Transaction tx =session.beginTransaction();
	
//	Save object
	session.save(student1);
	session.save(student2);
	
	tx.commit();
	
	factory.close();
}
}
