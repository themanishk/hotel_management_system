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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "position_type")
public class position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_id")
	private int id;
	
	@Column(name="pos_name")
	private String posname;
	
	@Column(name = "role_type")
	private String type;
	
	   @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
	    private List<log_in> log_in = new ArrayList<log_in>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosname() {
		return posname;
	}

	public void setPosname(String posname) {
		this.posname = posname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<booking> getLogin() {
		return log_in;
	}

	public void setLogin(List<booking> login) {
		this.log_in = login;
	}
	
	    
	    
	
}