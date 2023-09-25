package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Register;

public class RegisterDao {
	 static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Soumya");
	 
	 public static boolean saveDetails(Register r) {
		 try {
			 EntityManager em = emf.createEntityManager();
			 EntityTransaction et = em.getTransaction();
			 et.begin();
			 em.persist(r);
			 et.commit();
			 return true;
		 } catch (Exception e) {
			 e.printStackTrace();
			 return false;
		 }
	 }
	 
	 public static Register findByEmail(String email , String password) {
		 EntityManager em = emf.createEntityManager();
		 Query q = em.createQuery("SELECT u FROM Register u WHERE u.email='"+email+"' AND u.password='"+password+"'") ;
		 if(q.getResultList().isEmpty())
			 return null ;
		 return (Register)q.getResultList().get(0) ;
	 }
	 
	 public static Register findById(int id) {
		 EntityManager em = emf.createEntityManager();
		 return em.find(Register.class, id);
	 }
}


