package org.anurag.HibernateBasicsDurgesh;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException{
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);

		// Creating Student

//		Student st = new Student();
//		st.setId(101);
//		st.setName("John");
//		st.setCity("Delhi");
//		System.out.println(st);
		
		//Craeting Address class Object
		Address ad = new Address();
		ad.setStreet("Street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.1234);
		//Reading image
		FileInputStream fis = new FileInputStream("src/main/java/1639990001485.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

//		session.save(st);
		session.save(ad);
		
		tx.commit();

		fis.close();
		session.close();
		factory.close(); 
		
		System.out.println("Done");
	}


}
