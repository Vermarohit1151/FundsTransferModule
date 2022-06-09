package base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class BaseDAOImpl implements BaseDAO {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	public BaseDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void persist(Object obj) { //user defined function
		
		entityManager = entityManagerFactory.createEntityManager();
		
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
				entityManager.persist(obj); //ORM's perist
			tx.commit();
		}
		finally {
			entityManager.close(); //close the session
		}
	}
	
	public void merge(Object obj) { //user defined function
		
		entityManager = entityManagerFactory.createEntityManager();
		
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
				entityManager.merge(obj); //ORM's merge
			tx.commit();
		}
		finally {
			entityManager.close(); //close the session
		}
	}

	public void remove(Object obj) { //user defined function
		
		entityManager = entityManagerFactory.createEntityManager();
		
		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
				entityManager.remove(obj); //ORM's remove
				tx.commit();
		}
		finally {
			entityManager.close(); //close the session
		}
	
	}
	
	
	public <AnyType> AnyType find(Class<AnyType> className, Serializable primaryKey ) { //user defined function
	
		entityManager = entityManagerFactory.createEntityManager();
		
		try {
				AnyType e = entityManager.find(className,primaryKey);
				return e;
		}
		finally {
			entityManager.close(); //close the session
		}
	} 

	public <AnyType> List<AnyType> findAll(String entityName) { //user defined function
		
		entityManager = entityManagerFactory.createEntityManager();
		
		try {
			Query query = entityManager.createQuery("from "+entityName);
				
			return query.getResultList();
		}
		finally {
			entityManager.close(); //close the session
		}
	}

	
	
		
}