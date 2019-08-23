package ee.sda.hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ee.sda.hibernate.entities.Transaction;

public class JpqlApplicationExpressionsandOperators {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try{
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Transaction> query = em.createQuery("from Transaction t" +
					" where  (t.amount between ?1 and ?2) and t.title like '%s'" +
					" order by t.title", Transaction.class);
			System.out.println("Please provide the first amount:");
			query.setParameter(1, new BigDecimal(scanner.next()));
			System.out.println("Please provide the second amount:");
			query.setParameter(2, new BigDecimal(scanner.next()));

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
