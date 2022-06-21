package com.learnersacademy.trg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learnersacademy.trg.dto.ClassDetails;
import com.learnersacademy.trg.dto.Student;
import com.learnersacademy.trg.util.HibernateUtil;

public class ClassDetailsDaoImpl implements ClassDetailsDao {
	    private SessionFactory factory;
		private Session session;
	public ClassDetailsDaoImpl() {
		    factory= HibernateUtil.getSessionFactory();
			session=HibernateUtil.getSession();
	}

	@Override
	public boolean validTeacher(int teacher) {
		return session.getSession()
                .createQuery("SELECT t.teacher_id FROM Teachers t WHERE t.teacher_id=:teacher")
                .setParameter("teacher", teacher)
                .uniqueResult() != null;
				
	}

	@Override
	public boolean validSubject(String subject) {
				return session.getSession()
                .createQuery("SELECT s.sub_name FROM Subjects s WHERE s.sub_name=:subject")
                .setParameter("subject", subject)
                .uniqueResult() != null;
		
	}

	@Override
	public Integer addClassDetails(ClassDetails classDetails) {
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
   		Integer sno=(Integer)session.save(classDetails);
		txn.commit();
		session.close();
		return sno;
	}

	@Override
	public List<ClassDetails> classReport(String class_in) {
		 Session session=factory.openSession();
		    Query<ClassDetails> query = session.createQuery(" FROM ClassDetails WHERE class_in=:class_in");
		    query.setParameter("class_in",class_in);
		    List<ClassDetails> list1=(List<ClassDetails>)query.getResultList();
		   return list1;
	}

	
}
