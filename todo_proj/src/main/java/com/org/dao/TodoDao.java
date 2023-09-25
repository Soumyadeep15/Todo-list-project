package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Register;
import com.org.dto.Todo;

public class TodoDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Soumya");
	
	public static boolean saveData(Todo td) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(td);
			et.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Todo> viewData( int id) {
		System.out.println(";;;;;;id"+id);
		Register user = RegisterDao.findById(id);
		EntityManager em = emf.createEntityManager();
		
		javax.persistence.Query q = em.createQuery("SELECT td FROM Todo td WHERE td.reg=?1");
		q.setParameter(1, user); 
		
		 return q.getResultList();
	}
	
	public static boolean deleteData(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Todo td = em.find(Todo.class, id);
		if(td == null) return false;
		else {
			et.begin();
			em.remove(td);
			et.commit();
			return true;
		}
	}
	
	
	
	public static boolean updateList(Todo td,int id) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Register find = em.find(Register.class, id);
//			find.setId(td.getId());
//			find.setDate(td.getDate());
//			find.setDescription(td.getDescription());
//			find.setStatus(td.getStatus());;
			td.setReg(find);			
			et.begin();
			em.merge(td);
			et.commit();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Todo findById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Todo.class, id);
	}
}
