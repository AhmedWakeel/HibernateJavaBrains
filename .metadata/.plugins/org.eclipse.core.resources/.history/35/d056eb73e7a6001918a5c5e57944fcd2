package com.brains.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@NamedQuery(name="USER_DETAILS.byId",query="from UserDetails where userId= :userId ")
@NamedNativeQuery(name="User-details.byName" ,query="select * from USER_DETAILS where userName = ? ",resultClass=UserDetails.class)
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
