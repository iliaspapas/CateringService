package gr.hua.dit.entity;


import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement(name = "Accepted")
@Entity
@Table(name = "Accepted")
public class Accepted {

	   @Id
	   @Column(name = "Am")
	   private int am;

	   @Column(name = "Score")
	   private int score;


	   
	public Accepted() {
		super();
	}

	


	public Accepted(int am, int score) {
		super();
		this.am = am;
		this.score = score;
		
	}




	public int getAm() {
		return am;
	}




	public void setAm(int am) {
		this.am = am;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	




	@Override
	public String toString() {
		return "Accepted [am=" + am + ", score=" + score + "]";
	}

	

		   
	   
}
	   