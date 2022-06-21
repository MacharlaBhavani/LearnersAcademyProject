package com.learnersacademy.trg.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnersacademy.trg.dto.Subjects;
import com.learnersacademy.trg.util.HibernateUtil;

public class SubjectsDaoImpl implements SubjectsDao{
	
	private SessionFactory factory;
	   public SubjectsDaoImpl() {
		   factory= HibernateUtil.getSessionFactory();
	   }

	@Override
	public Integer addSubject(Subjects subjects) {
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		Integer sub_id=(Integer)session.save(subjects);
		txn.commit();
		session.close();
		return sub_id;
	}

}
