package org.arpaul.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		
//		Query query = session.createQuery("from UserDetails");// append the query  where userId > 5
//		query.setFirstResult(5);// Pagination concepts
//		query.setMaxResults(4);
//		List<UserDetails> users = (List<UserDetails>) query.list();
		
		// select statement can be used for the only required fields
		// but then the List doesnt stay as UserDetails it becomes List of String or List of List of String if multiple strings are fetched
//		Query query = session.createQuery("select userName from UserDetails");
//		query.setFirstResult(5);// Pagination concepts
//		query.setMaxResults(4);
//		List<String> users = (List<String>) query.list();
		
		int minUserId = 5;
		String userName = "User 10";
//		Query query = session.createQuery("from UserDetails where userId > ?1 and userName = ?2");
//		query.setInteger(1, minUserId);
//		query.setString(2, userName);
		
//		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
//		query.setInteger("userId", minUserId);
//		query.setString("userName", userName);
//		List<UserDetails> users = (List<UserDetails>) query.list();
		
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, 2);
//		Query query = session.getNamedQuery("UserDetails.byName");
//		query.setString(0, "User 7");
//		session.getTransaction().commit();
//		List<UserDetails> users = (List<UserDetails>) query.list();
		
//		Criteria criteria = session.createCriteria(UserDetails.class);
//		criteria
//			.add(Restrictions.or(Restrictions.between("userId", 5, 10), Restrictions.like("userName", "User %")))
//			.add(Restrictions.eq("userName", "User 10"))
//			.add(Restrictions.ge("userId", 5));// chaining of multiple criteria is allowed
		
//		Criteria criteria = session.createCriteria(UserDetails.class)
////				.setProjection(Projections.count("userId"))
//				.addOrder(Order.desc("userId"));
////				.setProjection(Projections.property("userId"));
//		session.getTransaction().commit();
//		List<UserDetails> users = (List<UserDetails>) criteria.list();
		
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1);
		
		UserDetails userDetails2 = (UserDetails) session.get(UserDetails.class, 1);// Perform 1st level cache doesn't call the DB
		session.getTransaction().commit();
		session.close();// User object becomes detached, its no more tracked by hibernate.
		
//		for(UserDetails userDetail : users) {
//			System.out.println(userDetail.getUserName());	
//		}
		
//		for(String userDetail : users) {
//			System.out.println(userDetail);	
//		}
//		user = null;
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		user = (UserDetails) session.get(UserDetails.class, 1);
//		System.out.println("User name retrieved >> " + user.getUserName());
//		session.close();// If session is closed before fetching collection then fetchtype needs to be eager
//		System.out.println("User List of Addresses >> " + user.getListOfAddress().size());
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		// Since session is closed 1st level cache is closed too, so select query runs again
		UserDetails userDetails3 = (UserDetails) session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
	}

}
