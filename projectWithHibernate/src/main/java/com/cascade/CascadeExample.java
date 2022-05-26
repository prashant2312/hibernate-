package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fetch.Answers;
import com.fetch.Questions;

public class CascadeExample {
	public static void main(String[] args) {
		System.out.println("Running");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Questions q1 = new Questions();
		q1.setQuestionId(13);
		q1.setQuestion("What is spring");

		Answers a1 = new Answers();
		a1.setAnswer("Spring is a good tool");
		a1.setQuestion(q1);
		Answers a2 = new Answers();
		a2.setAnswer("Second");
		a2.setQuestion(q1);
		Answers a3 = new Answers();
		a3.setAnswer("third");
		a3.setQuestion(q1);
		
		List<Answers> list = new ArrayList<Answers>();
		list.add(a3);
		list.add(a2);
		list.add(a1);

		q1.setAnswer(list);

		Session s = factory.openSession();
		Transaction transaction = s.beginTransaction();

		s.save(q1);

		transaction.commit();

		factory.close();
		System.out.println("Done");
	}
}
