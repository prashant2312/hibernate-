package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.Address;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//        
//        
////        ONETOONE
////        Create question
//        Question q1=new Question();
//        
////      Creating answer
//      Answer answer1=new Answer();
//      answer1.setAnswerId(234);
//      answer1.setAnswer("Java is programming language");
//     
//    Answer answer2=new Answer();
//    answer2.setAnswerId(344);
//    answer2.setAnswer("With java create programs.");	
//      
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is java?");
//        answer1.setQuestion(q1);
//
//
////
//////        QUestion 2
////        //        Create question
//        Question q2=new Question();
//
//        
////      Creating answer
//      Answer answer2=new Answer();
//      answer2.setAnswerId(344);
//      answer2.setAnswer("Api work with objects in java.");
//        q2.setAnswer(answer2);
//        q2.setQuestionId(2242);
//        q2.setQuestion("What is collection framework?");
//        answer2.setQuestion(q2);
//
//
//
////        Session
//        Session session=factory.openSession();
//
//        Transaction tx=session.beginTransaction();
//
////        save
//        session.save(answer1);
//        session.save(answer2);
//        session.save(q1);
////        session.save(q2);
//        tx.commit();
//        
//        
//        
////        Fetching data
//        Question question = session.get(Question.class, 1212);
//        System.out.println(question.getQuestion());
////        System.out.println(question.getAnswer().getAnswer());
//        factory.close();

        
        
        
        
        
//        One to many
        System.out.println("Running");
        Question q1=new Question();
        q1.setQuestionId(1);
        q1.setQuestion("What is java?");
        
        Answer a1=new Answer();
        a1.setAnswer("Java is a Programming language");
        a1.setQuestion(q1);
        
        Answer a2=new Answer();
        a2.setAnswer("It is used to write code");
        a2.setQuestion(q1);
        
        Answer a3=new Answer();
        a3.setAnswer("Is is a famous language");
        a3.setQuestion(q1);
        
        List<Answer> list=new ArrayList<Answer>();
        
        list.add(a1);
        list.add(a2);
        list.add(a3);
        
        q1.setAnswer(list);
        
       Session session=factory.openSession();
       Transaction txs=session.beginTransaction();
       
       session.save(a1);
       session.save(a2);
       session.save(a3);
       session.save(q1);
              
       txs.commit();
        
  
        Question q=session.get(Question.class, 1);
        System.out.println(q.getQuestion());
//        for(Answer a:q.getAnswer()) {
//        	System.out.println(a.getAnswer());
//        }
        
  session.close();      
        System.out.println("Finished");
        
//        Many to many
        
        
    }
}
