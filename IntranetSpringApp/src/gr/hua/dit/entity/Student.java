package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
@Entity
@Table(name = "Student")
public class Student {
	   @Id
	   @Column(name = "Username")
	   private int username;

	   @Column(name = "Password")
	   private String password;
	   
	   @Column(name = "Phone")
	   private int phone;
	   
	   @Column(name = "Email")
	   private String email;

	public Student(int username, String password, int phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	   
	   
}
