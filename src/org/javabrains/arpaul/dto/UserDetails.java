package org.javabrains.arpaul.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
//@Entity (name="USER_DETAILS")
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id	// Cannot be used if id is a object, need to use @EmbeddedId
	@GeneratedValue(strategy=GenerationType.AUTO)	// Cannot be used if id is a object, need to use @EmbeddedId
	@Column(name="USER_ID")
	private int userId;
//	@Column(name="USER_NAME")
//	@Basic
//	@Transient  // Used when if we don't want this variable to create a column in the db table
	private String userName;
	@Temporal(TemporalType.DATE) // Used to specify which date format to use while accessing the db table
	private Date joinedDate;
	@Embedded //This also explains if this object is embedded. Not necessary if already object is declared as Embeddable.
	@AttributeOverrides({ // Allows to override multiple instances of embedded object
		@AttributeOverride (name="street", column=@Column(name="HOME_STREET_NAME")), // Overrides one instance of embedded object
		@AttributeOverride (name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride (name="state", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride (name="pincode", column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	@Embedded 
	private Address officeAddress;
	@Lob	// Used to specify a large object if assigned on top of a String then its considered as COB Char Object if above a byte then considered as BLOB
	private String description;
	@ElementCollection	// Informs hibernate to save this collection
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "my-generator", strategy = "increment")// hilo is a type of generator which hibernate provides
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "my-generator", type = @Type(type="long"))// defines this list needs an identifier
	private Collection<Address> listOfAddress = new ArrayList<>();// In order to use a list of object as member variable arraylist is required
//	private Set<Address> listOfAddress = new HashSet<>();

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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
	
}
