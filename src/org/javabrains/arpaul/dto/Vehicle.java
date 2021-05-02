package org.javabrains.arpaul.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)	// Single table inhertance strategy, all child entities will be added to parent entity
//@DiscriminatorColumn(
//		name="VEHICLE_TYPE", 
//		discriminatorType=DiscriminatorType.STRING) // Only needed for Single table inheritance
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // Multiple table for each and every entity(child entities also has it's table)
@Inheritance(strategy=InheritanceType.JOINED) // Creates multiple table for all entities but the inherited values stays in parent table only, need to join query to check all data
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
//	@ManyToOne
//	private UserDetails user;// Either use One to Many is parent class or here
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
//	private UserDetails user;
	
//	@ManyToMany(mappedBy="vehicle")
//	private Collection<UserDetails> user = new ArrayList<UserDetails>();
	
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
//	private UserDetails user;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
//	public UserDetails getUser() {
//		return user;
//	}
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
	
	
}
