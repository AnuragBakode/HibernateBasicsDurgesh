package org.anurag.HibernateBasicsDurgesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Student st = (Student)session.get(Student.class, 108);
		Address ad = (Address)session.load(Address.class, 1);
		System.out.println(ad);
		
		session.close();
		factory.close();
	}
	
	
	
	
}
