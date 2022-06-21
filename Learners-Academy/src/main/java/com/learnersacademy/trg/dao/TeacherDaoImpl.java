package com.learnersacademy.trg.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learnersacademy.trg.dto.Teachers;
import com.learnersacademy.trg.util.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao {
	private SessionFactory factory;
	   public TeacherDaoImpl() {
		   factory= HibernateUtil.getSessionFactory();
	   }
	@Override
	public Integer addTeacher(Teachers teachers) {
			Session session=factory.openSession();
			Transaction txn=session.beginTransaction();
			Integer teacher_id=(Integer)session.save(teachers);
			txn.commit();
			session.close();
			return teacher_id;
		
	}
	

}
