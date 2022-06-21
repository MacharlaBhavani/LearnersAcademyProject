package com.learnersacademy.trg.util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.learnersacademy.trg.dto.ClassDetails;
import com.learnersacademy.trg.dto.Classes;
import com.learnersacademy.trg.dto.Student;
import com.learnersacademy.trg.dto.Subjects;
import com.learnersacademy.trg.dto.Teachers;



public class HibernateUtil {
 private static SessionFactory factory;
    public static SessionFactory getSessionFactory() {
    	  if(factory==null) {
    			 Configuration cfg=new Configuration();
    			 Properties properties=new Properties();
       			 properties.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
    			 properties.setProperty(Environment.URL,"jdbc:mysql://localhost:3306/project3");
    			 properties.setProperty(Environment.USER,"root");
    			 properties.setProperty(Environment.PASS,"Bhavani@47");
    			 properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
      			 properties.setProperty(Environment.SHOW_SQL,"true");
    			 properties.setProperty(Environment.HBM2DDL_AUTO,"update");
    			 
    			 cfg.setProperties(properties);
    			 
    			 cfg.addAnnotatedClass(Student.class);
    			 cfg.addAnnotatedClass(Teachers.class);
    			 cfg.addAnnotatedClass(Classes.class);
    			 cfg.addAnnotatedClass(Subjects.class);
    			 cfg.addAnnotatedClass(ClassDetails.class);
    			 
    			 ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
    			 factory=cfg.buildSessionFactory(registry);
    			 
    			 return factory;
    		  }
    		return factory;
    	  }
    public static Session getSession() throws HibernateException {         
    	   Session sess = null;       
    	   try {         
    	       sess = factory.getCurrentSession();  
    	   } catch (org.hibernate.HibernateException he) {  
    	       sess = factory.openSession();     
    	   }             
    	   return sess;
    	} 
}
