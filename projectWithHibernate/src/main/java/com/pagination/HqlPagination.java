package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tute.Student;

public class HqlPagination {
public static void main(String[] args) {
	System.out.println();
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	
	Session s=factory.openSession();
	Query query = s.createQuery("from Student");
	query.setFirstResult(0);
	query.setMaxResults(8);
	
	List<Student> list = query.list();
	
	for(Student st:list) {
		System.out.println(st.getName()+" "+st.getCity()+" "+st.getId());
	}
	
	factory.close();
}
}
