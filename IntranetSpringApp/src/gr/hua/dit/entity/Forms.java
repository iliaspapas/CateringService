package gr.hua.dit.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Forms")
@Entity
@Table(name = "Forms")
public class Forms {

	
	
	 	@Id
	   @Column(name = "Am")
	   private int am;

	   @Column(name = "First_name")
	   private String first_name;

	   @Column(name = "Last_name")
	   private String last_name;

	   @Column(name = "Income")
	   private int income;
	   
	   @Column(name="Fincome")
	   private int fincome;
	   
	   @Column(name = "Bstudying")
	   private int bstudying;
	   
	   @Column(name = "Scity")
	   private String scity;
	   
	   @Column(name = "City")
	   private String city;
	   
	   
	   
	   
	   
	    
	   

	
	




	public Forms(int am, String first_name, String last_name, int income, int fincome, int bstudying, String scity,
			String city) {
		super();
		this.am = am;
		this.first_name = first_name;
		this.last_name = last_name;
		this.income = income;
		this.fincome = fincome;
		this.bstudying = bstudying;
		this.scity = scity;
		this.city = city;
		
	}




	public Forms() {
		
	}




	


	public int getAm() {
		return am;
	}




	public void setAm(int am) {
		this.am = am;
	}




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public int getIncome() {
		return income;
	}




	public void setIncome(int income) {
		this.income = income;
	}




	public int getFincome() {
		return fincome;
	}




	public void setFincome(int fincome) {
		this.fincome = fincome;
	}




	public int getBstudying() {
		return bstudying;
	}




	public void setBstudying(int bstudying) {
		this.bstudying = bstudying;
	}




	public String getScity() {
		return scity;
	}




	public void setScity(String scity) {
		this.scity = scity;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	




	@Override
	public String toString() {
		return "Forms [am=" + am + ", first_name=" + first_name + ", last_name=" + last_name + ", income=" + income
				+ ", fincome=" + fincome + ", bstudying=" + bstudying + ", scity=" + scity + ", city=" + city
				+  "]";
	}




	
	
	

	   
}
