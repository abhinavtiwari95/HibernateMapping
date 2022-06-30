package com.hibernatemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {

    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Laptop laptop1 = new Laptop();
    	laptop1.setLid(102);
    	laptop1.setLname("hp");
    	
    	Laptop laptop2 = new Laptop();
    	laptop2.setLid(103);
    	laptop2.setLname("asser");
    	
    	Laptop laptop3 = new Laptop();
    	laptop3.setLid(104);
    	laptop3.setLname("mi");
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Rohit");
    	student.setMarks(50);
    	student.getLaptop().add(laptop);
    	student.getLaptop().add(laptop1);
    	

    	
    
    	
 
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("persist.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	Transaction transa = session.beginTransaction();
    	
    	session.persist(laptop);
    	session.persist(laptop1);
    	session.persist(laptop2);
    	session.persist(laptop3);
    	session.persist(student);
    	
    	
    	transa.commit();
    	session.close();
    }
}
