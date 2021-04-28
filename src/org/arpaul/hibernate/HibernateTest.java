package org.arpaul.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.arpaul.dto.Address;
import org.javabrains.arpaul.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Aritra");
		Address homeAddress = new Address();
		homeAddress.setState("West bengal");
		homeAddress.setCity("Kolkata");
		user.setHomeAddress(homeAddress);
		Address officeAddress = new Address();
		officeAddress.setState("Telengana");
		officeAddress.setCity("Hyderabad");
		user.setOfficeAddress(officeAddress);
		user.setJoinedDate(new Date());
		user.setDescription("Description of th user goes here.");
		
		Address address1 = new Address();
		address1.setState("List State 1");
		address1.setCity("List City 1");
		address1.setStreet("List Street 1");
		address1.setPincode("List Pincode 1");
		
		Address address2 = new Address();
		address2.setState("List State 2");
		address2.setCity("List City 2");
		address2.setStreet("List Street 2");
		address2.setPincode("List Pincode 2");
		
		user.getListOfAddress().add(address1);
		user.getListOfAddress().add(address2);

		SessionFactory  sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name retrieved >> " + user.getUserName());
	}

}
