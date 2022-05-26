package com.fetch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Questions {
    @Id
    @Column(name="question_id")
    private int questionId;
    private String question;
//    @OneToOne
//    @JoinColumn(name = "a_id")      
//    private Answer answer;
    
//    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answers> answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answers> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answers> answer) {
		this.answer = answer;
	}

	public Questions(int questionId, String question, List<Answers> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
  
    
}
