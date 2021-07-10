package com.demo2.demo2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class user {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "emp_id")
		private int id;
		
		@NotBlank(message="name is compulsory")
		@Column(name = "name")
		private String name;
		
		@NotBlank(message="mobile no. is compulsory")
		@Size(min=10, max =12, message="invalid mob no.")
		@Column(name = "mobile")
		private String mobile;
		
		@NotBlank(message="email is compulsory")
		@Email(message = "Email is invalid")
		@Column(name = "email")
		private String email;
		
		

	    
	    
	    

	    

	    
	   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<booking> booking = new ArrayList<booking>();
	    //private Set<Book> books = new HashSet<>();*/










	public int getId() {
		return id;
	}










	public void setId(int id) {
		this.id = id;
	}










	public String getName() {
		return name;
	}










	public void setName(String name) {
		this.name = name;
	}










	public String getMobile() {
		return mobile;
	}










	public void setMobile(String mobile) {
		this.mobile = mobile;
	}










	public String getEmail() {
		return email;
	}










	public void setEmail(String email) {
		this.email = email;
	}










	public List<booking> getBooking() {
		return booking;
	}










	public void setBooking(List<booking> booking) {
		this.booking = booking;
	}
	    































	
	    
	    
	    





	    
		
	
	
	


}
