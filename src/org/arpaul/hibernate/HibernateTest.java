package org.arpaul.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.javabrains.arpaul.dto.Address;
import org.javabrains.arpaul.dto.FourWheeler;
import org.javabrains.arpaul.dto.TwoWheeler;
import org.javabrains.arpaul.dto.UserDetails;
import org.javabrains.arpaul.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
//		Address homeAddress = new Address();
//		homeAddress.setState("West bengal");
//		homeAddress.setCity("Kolkata");
//		user.setHomeAddress(homeAddress);
//		Address officeAddress = new Address();
//		officeAddress.setState("Telengana");
//		officeAddress.setCity("Hyderabad");
//		user.setOfficeAddress(officeAddress);
//		user.setJoinedDate(new Date());
//		user.setDescription("Description of th user goes here.");
		
//		Address address1 = new Address();
//		address1.setState("List State 1");
//		address1.setCity("List City 1");
//		address1.setStreet("List Street 1");
//		address1.setPincode("List Pincode 1");
//		
//		Address address2 = new Address();
//		address2.setState("List State 2");
//		address2.setCity("List City 2");
//		address2.setStreet("List Street 2");
//		address2.setPincode("List Pincode 2");
//		
//		user.getListOfAddress().add(address1);
//		user.getListOfAddress().add(address2);
		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("Bike");
		
//		user.setVehicle(vehicle);
//		user.getVehicle().add(vehicle);
//		user.getVehicle().add(vehicle2);
//		vehicle.getUser().add(user);
//		vehicle2.getUser().add(user);

		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("Vehicle");
//		TwoWheeler bike = new TwoWheeler();
//		bike.setVehicleName("Bike");
//		bike.setSterringHandle("Steering handle");
//		
//		FourWheeler fourWheeler = new FourWheeler();
//		fourWheeler.setVehicleName("Car");
//		fourWheeler.setSteeringWheel("Steering wheel");
		
		UserDetails user = new UserDetails();
		user.setUserName("Aritra"); // A Transient object is created
		
		SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		session.persist(user);// Cascade effect

		//		session.save(user);
//		session.save(vehicle);
//		session.save(vehicle2);
		
//		session.save(vehicle);
//		session.save(bike);
//		session.save(fourWheeler);
//		for(int i = 0; i < 10; i++) {
//			UserDetails userDetails = new UserDetails();
//			userDetails.setUserName("User "+(i+1));
//			session.save(userDetails);
//		}
		
//		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 4);
//		System.out.println("User name retrieved >> " + userDetails.getUserName());
//		userDetails.setUserName("Update this user");
//		session.update(userDetails);
//		session.delete(userDetails);
		
//		session.save(user); // User object becomes persistent
//		user.setUserName("Updated user"); // User object is tracked by hibernate once save is complete
		
		Query query = session.createQuery("from UserDetails where userId > 5");
		List users = query.list();
		session.getTransaction().commit();
		
		session.close();// User object becomes detached, its no more tracked by hibernate.
		
		System.out.println("User list size: "+users.size());
//		user = null;
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		user = (UserDetails) session.get(UserDetails.class, 1);
//		System.out.println("User name retrieved >> " + user.getUserName());
//		session.close();// If session is closed before fetching collection then fetchtype needs to be eager
//		System.out.println("User List of Addresses >> " + user.getListOfAddress().size());
	}

}
