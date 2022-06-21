package com.learnersacademy.trg.dao;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnersacademy.trg.dto.Classes;
import com.learnersacademy.trg.util.HibernateUtil;


public class ClassesDaoImpl implements ClassesDao {
	private SessionFactory factory;
	private Session sess;
	public ClassesDaoImpl() {
		factory= HibernateUtil.getSessionFactory();
		sess=HibernateUtil.getSession();
						
	}
	
	
	@Override
	public Integer addClasses(Classes classes) {
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
   		Integer sno=(Integer)session.save(classes);
		txn.commit();
		session.close();
		return sno;
	}




	@Override
	@Transactional
	public boolean validClass(String classof) {
		return sess.getSession()
		                         .createQuery("SELECT c.classof FROM Classes c WHERE c.classof=:classof")
		                         .setParameter("classof", classof)
		                         .uniqueResult() != null;
		}
	

	}




	

	
	


	


