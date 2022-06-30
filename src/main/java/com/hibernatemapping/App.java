package com.hibernatemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//
public class App 
{
    public static void main( String[] args )
    {

    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	
    	Laptop laptop1 = new Laptop();
    	laptop1.setLid(102);
    	laptop1.setLname("HP");
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Rohit");
    	student.setMarks(50);
    	student.getLaptop().add(laptop1);
    	student.getLaptop().add(laptop);
    	
    	Student student1 = new Student();
    	student1.setRollno(2);
    	student1.setName("Ajit");
    	student1.setMarks(20);
    	student1.getLaptop().add(laptop1);
    	
    	Student student2 = new Student();
    	student2.setRollno(3);
    	student2.setName(" Ankit");
    	student2.setMarks(80);
    	student2.getLaptop().add(laptop1);
    	
    	laptop.getStudent().add(student);
    	laptop1.getStudent().add(student1);
    	
 
    	
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("persist.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	Transaction transa = session.beginTransaction();
    	
    	session.persist(laptop);
    	session.persist(student);
    	session.persist(laptop1);
    	session.persist(student1);
    	session.persist(student2);
    	
    	transa.commit();
    	session.close();
    }
}
