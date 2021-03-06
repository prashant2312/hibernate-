package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tute.Student;

public class CriteriaApiDemo {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Session session=factory.openSession();
	
	Criteria c= session.createCriteria(Student.class);
	
//	c.add(Restrictions.eq("certi.course", "Btech"));
	
//	c.add(Restrictions.gt("id", 4));
	c.add(Restrictions.like("certi.course", "NTT%"));
	
	List<Student> list = c.list();
	
	for(Student s:list) {
		System.out.println(s);
	}
	
	session.close();
	factory.close();
}
}
