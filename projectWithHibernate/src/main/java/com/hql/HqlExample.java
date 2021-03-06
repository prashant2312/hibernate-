package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.Student;

import java.util.Arrays;
import java.util.List;


import org.hibernate.query.Query;

public class HqlExample {
	public static void main(String [] a) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//		HQL
//			String query = "from Student where city='ABCD'";
			String query = "from Student as s where s.city=:x and s.name=:n";

			Session s = factory.openSession();

			Query q = s.createQuery(query);
			q.setParameter("x", "ABC");
			q.setParameter("n", "name");

//		single result unique
//		q.uniqueResult();

//		Multiple result
			List<Student> list = q.list();
			for (Student student : list) {
				System.out.println(student.getName()+" " +student.getCity());
			}
			
			System.out.println("________________________");
			
			Transaction tx=s.beginTransaction();
			
//			Query query2 = s.createQuery("delete from Student s where s.city=:c");
//			query2.setParameter("c", "ABC");
//			int executeUpdate = query2.executeUpdate();
//			System.out.println("deleted :- "+executeUpdate);
			
			
//			update query
//			Query q2= s.createQuery("update Student set duration=:d where name=:n");
//			q2.setParameter("d", "2 month");
//			q2.setParameter("n", "Demon2");
//			int executeUpdate = q2.executeUpdate();
//			
		
			
			
//			Execute join query
			Query createQuery = s.createQuery("select q.question,"
					+ "q.questionId,a.answer from Questions as q "
					+ "inner join q.answer as a");
			List<Object []> list3 = createQuery.getResultList();
			for(Object[] arr:list3) {
				System.out.println(Arrays.toString(arr));
			}
			
			tx.commit();
			s.close();

			factory.close();
	}
}
