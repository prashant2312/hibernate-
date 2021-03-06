package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//        Create question
        Question q1=new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");

//        Creating answer
        Answer answer1=new Answer();
        answer1.setAnswerId(234);
        answer1.setAnswer("Java is programming language");
        q1.setAnswer(answer1);



//        QUestion 2
        //        Create question
        Question q2=new Question();
        q2.setQuestionId(2242);
        q2.setQuestion("What is collection framework?");

//        Creating answer
        Answer answer2=new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("Api work with objects in java.");
        q2.setAnswer(answer2);



//        Session
        Session session=factory.openSession();

        Transaction tx=session.beginTransaction();

//        save
        session.save(q1);
        session.save(q2);

        factory.close();

    }
}
