package com.demo2.demo2.model;

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
@Table(name = "permission")
public class permission {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "per_id")
		private int per_id;
		
		@Column(name="per_type")
		private String pertype;
		
		@Column(name = "per_name")
		private String per_name;
		
	    //@OneToMany(mappedBy = "permission", fetch = FetchType.LAZY,
	   //         cascade = CascadeType.ALL)
	 //   private Set<position> permission;

		public int getPer_id() {
			return per_id;
		}

		public void setPer_id(int per_id) {
			this.per_id = per_id;
		}

		public String getPertype() {
			return pertype;
		}

		public void setPertype(String per_type) {
			this.pertype = per_type;
		}

		public String getPer_name() {
			return per_name;
		}

		public void setPer_name(String per_name) {
			this.per_name = per_name;
		}




		




		
	
	
	


}
