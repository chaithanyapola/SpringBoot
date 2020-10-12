package com.familybudget.SpringBootApp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import com.familybudget.SpringBootApp.model.user;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "property_tb")
public class peroperties {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	 @SequenceGenerator(name = "per_id_Sequence", sequenceName = "PER_ID_SEQ")
	 private long perid;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private user users;
	
	@Column(nullable=false)
	private String Property;
	
	@Column(nullable=false)
	private String Property_pl;
	
	@Column(nullable=false)
	private long Property_value;
	
	@CreationTimestamp
	private Date last_updated;
	
	private String pr_remarks;

	public long getPerid() {
		return perid;
	}

	public void setPer_id(long perid) {
		this.perid = perid;
	}

	public user getUser() {
		return users;
	}

	public void setUser(user user) {
		users = user;
	}

	public String getProperty() {
		return Property;
	}

	public void setProperty(String property) {
		Property = property;
	}

	public String getProperty_pl() {
		return Property_pl;
	}

	public void setProperty_pl(String property_pl) {
		Property_pl = property_pl;
	}

	public long getProperty_value() {
		return Property_value;
	}

	public void setProperty_value(long property_value) {
		Property_value = property_value;
	}

	public Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	public String getPr_remarks() {
		return pr_remarks;
	}

	public void setPr_remarks(String pr_remarks) {
		this.pr_remarks = pr_remarks;
	}

	@Override
	public String toString() {
		return "peroperties [perid=" + perid + ", User=" + users + ", Property=" + Property + ", Property_pl="
				+ Property_pl + ", Property_value=" + Property_value + ", last_updated=" + last_updated
				+ ", pr_remarks=" + pr_remarks + "]";
	}

		
	

}
