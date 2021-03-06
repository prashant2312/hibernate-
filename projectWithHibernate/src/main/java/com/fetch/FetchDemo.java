package com.fetch;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class FetchDemo {
public static void main(String[] args) {
	System.out.println("Running");
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	Session s=factory.openSession();
	Transaction tx=s.beginTransaction();
	
	Questions q1=new Questions();
    q1.setQuestionId(1);
    q1.setQuestion("What is java?");
    
    Answers a1=new Answers();
    a1.setAnswer("Java is a Programming language");
    a1.setQuestion(q1);
    
    Answers a2=new Answers();
    a2.setAnswer("It is used to write code");
    a2.setQuestion(q1);
    
    Answers a3=new Answers();
    a3.setAnswer("Is is a famous language");
    a3.setQuestion(q1);
    
    List<Answers> list=new ArrayList<Answers>();
    
    list.add(a1);
    list.add(a2);
    list.add(a3);
    
    q1.setAnswer(list);
    s.save(a1);
    s.save(a2);
    s.save(a3);
    s.save(q1);
           
	Questions questions = s.get(Questions.class, 1);
    System.out.println(questions.getQuestion());
    
	tx.commit();
	
	factory.close();
}
}
