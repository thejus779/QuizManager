
package fr.epita.quiz.datamodel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class is dealing with the Question Entity
 *
 * @author  THEJUS
 *
 */
@Entity
public class Question implements Serializable{



	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1372241196520010694L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String question;
	private QuestionType type;

	/**
	 *
	 */
	public Question() {
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", type=" + type + "]";
	}
	
}
