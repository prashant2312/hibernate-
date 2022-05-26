package com.tute;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("PROJECT STARTED");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
//		Creating student
		Student st=new Student();
		st.setId(102);
		st.setName("Demon2");
		st.setCity("ABCD");
		
		
//		Creating address
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(123);
		
//		Reading Image
		FileInputStream fis=new FileInputStream("src/main/java/default.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
//		System.out.println(factory.isClosed());
//		System.out.println(st);
		
		Session session=factory.openSession();
//		
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
//		session.getTransaction().commit();
		tx.commit();		
		
		session.close();
		System.out.println("Done");
	}
}
