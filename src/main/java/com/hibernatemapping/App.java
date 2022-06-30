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
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Rohit");
    	student.setMarks(50);
    	student.setLaptop(laptop);
    	
    	//Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//    	ServiceRegistry sr = (ServiceRegistry) new StandardServiceRegistryBuilder().configure(null)
    	
    	
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("persist.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	Transaction transa = session.beginTransaction();
    	
    	session.persist(laptop);
    	session.persist(student);
    	
    	transa.commit();
    	session.close();
    }
}
