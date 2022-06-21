package com.learnersacademy.trg.dao;



import java.util.ArrayList;
import java.util.List;


import javax.persistence.TypedQuery;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learnersacademy.trg.dto.Student;
import com.learnersacademy.trg.util.HibernateUtil;


public class StudentDaoImpl implements StudentDao {
   private SessionFactory factory;
   public StudentDaoImpl() {
	   factory= HibernateUtil.getSessionFactory();
   }
	@Override
	public Integer addStudent(Student student) {
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		Integer student_id=(Integer)session.save(student);
		txn.commit();
		session.close();
		return student_id;
	}
	@Override
	public List<Student> findAllStudents() {
		    ArrayList<Student> allstudents;
		    String hql = "from Student";
		    Session session=factory.openSession();
		    TypedQuery<Student> typedquery = session.createQuery(hql);
		    allstudents=new ArrayList<Student>(typedquery.getResultList());
            return allstudents;
	}
	@Override
	public List<Student> specific(String class_in) {
		  
		    Session session=factory.openSession();
		    Query<Student> query = session.createQuery(" FROM Student WHERE class_in=:class_in");
		    query.setParameter("class_in",class_in);
		    List<Student> list=(List<Student>)query.getResultList();
		   return list;
}
	}

