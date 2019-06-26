package com.brains.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "UserDetails")
public class UserDetails {

	@Id 
//	@GeneratedValue // this annotation is used to add values automatically to the primary key column
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int userId;
	@Transient    // if we make any field transient then hibernate will igonre the that field and will not create the column in the table.
	private String userName;
	@Temporal(TemporalType.DATE)  // save only date and not time
	private Date joinedDate;
	@Lob   // by default hibernate uses 255 characters but if want to save more than that then we can use Large object , BLOB binary large object , CLOB character large object
	private String Address;
	private String Description;
    
	@Embedded
	private  Address address2;
	
	public Address getAddress2() {
		return address2;
	}
	public void setAddress2(Address address2) {
		this.address2 = address2;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
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
