package com.fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answers {
      @Id
    @Column(name = "answer_id")
      @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    private String answer;
//    @OneToOne(mappedBy = "answer")
//    private Question question;
    
    @ManyToOne
    private Questions question;
    
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answers(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
    
}
