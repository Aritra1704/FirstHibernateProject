package org.javabrains.arpaul.dto;

import java.util.Date;

import javax.persistence.Basic;
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
//@Entity (name="USER_DETAILS")
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
//	@Column(name="USER_NAME")
//	@Basic
//	@Transient  // Used when if we don't want this variable to create a column in the db table
	private String userName;
	@Temporal(TemporalType.DATE) // Used to specify which date format to use while accessing the db table
	private Date joinedDate;
	@Embedded //This also explains if this object is embedded. Not necessary if already object is declared as Embeddable.
	private Address address;
	@Lob	// Used to specify a large object if assigned on top of a String then its considered as COB Char Object if above a byte then considered as BLOB
	private String description;
	
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
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate + ", address="
				+ address + ", description=" + description + "]";
	}
	
	
}
