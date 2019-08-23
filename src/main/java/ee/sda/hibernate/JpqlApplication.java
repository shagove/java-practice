package ee.sda.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ee.sda.hibernate.entities.Transaction;

public class JpqlApplication {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try{
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Transaction> query = em.createQuery("from Transaction t order by t.title", Transaction.class);
			List<Transaction> transactions = query.getResultList();

			for(Transaction t:transactions){
				System.out.println(t.getTitle());
			}

			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			factory.close();
		}
	}
}
