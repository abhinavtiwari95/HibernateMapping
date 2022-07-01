package com.hibernatemapping.OneToOne;



import com.hibernatemapping.OneToOneEntity.Laptop;
import com.hibernatemapping.OneToOneEntity.Student;

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
    
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Rohit");
    	student.setMarks(50);
    	
    	student.setLaptop(laptop);
 
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("persist1-1.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	Transaction transa = session.beginTransaction();
    	
    	session.persist(laptop);
    	session.persist(laptop1);
   
    	session.persist(student);

    	
    	transa.commit();
    	session.close();
    	
    }
}
