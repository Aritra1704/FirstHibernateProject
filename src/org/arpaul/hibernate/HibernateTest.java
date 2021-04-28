package org.arpaul.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.arpaul.dto.Address;
import org.javabrains.arpaul.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Aritra");
		Address address = new Address();
		address.setState("West bengal");
		address.setCity("Kolkata");
		user.setAddress(address);
		user.setJoinedDate(new Date());
		user.setDescription("Description of th user goes here.");

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
