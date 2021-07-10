package com.demo2.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "login")
public class log_in {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "login_id")
		private int id;
		
		@NotBlank(message="First name is compulsory")
		@Size(min=4, max =20, message="username should be at least 4 characters")
		@Column(name = "username")
		private String username;
		

		
	    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	    @JoinColumn(name = "position_id" , nullable=true)
	    private position position;
		


		@NotBlank(message="password is compulsory")
		@Column(name = "password")
		private String password;
		

		
	    @OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "emp_id", nullable = false)
	    private user user;
		


	


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public user getUser() {
			return user;
		}


		public void setUser(user user) {
			this.user = user;
		}





		public position getPosition() {
			return position;
		}


		public void setPosition(position position) {
			this.position = position;
		}


		@Override
		public String toString() {
			return "log_in [id=" + id + ", username=" + username + ", password=" + password 
					+ ", user=" + user + "]";
		}
	
	
	


}
