package com.brains.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class UserDetails {
 
	@Id 
//	@GeneratedValue // this annotation is used to add values automatically to the primary key column
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int userId;
//	@Transient    // if we make any field transient then hibernate will igonre the that field and will not create the column in the table.
	private String userName;
	
	@OneToMany(mappedBy="details")
    private Collection<Vehicle> collect = new ArrayList<Vehicle>(); 
	
	public Collection<Vehicle> getCollect() {
		return collect;
	}
	public void setCollect(Collection<Vehicle> collect) {
		this.collect = collect;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
