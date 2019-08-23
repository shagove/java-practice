package ee.sda.hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import ee.sda.hibernate.entities.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HqlApplicationExpressionsandOperators {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try{
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("select t from Transaction t " +
					"where t.amount > :amount and t.transactionType = 'Withdrawl'");
			System.out.println("Please specify an amount:");
			query.setParameter("amount", new BigDecimal(scanner.next()));
			List<Transaction> transactions = query.list();

			for(Transaction t:transactions){
				System.out.println(t.getTitle());
			}

			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
			factory.close();
		}
	}
}

