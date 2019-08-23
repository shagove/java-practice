package ee.sda.hibernate;

import java.math.BigDecimal;
import java.util.List;

import ee.sda.hibernate.entities.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HibernateApplicationFilteringData {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			Criterion criterion1 = Restrictions.le("amount", new BigDecimal(
					"20.00"));
			Criterion criterion2 = Restrictions.eq("transactionType",
					"Withdrawl");

			List<Transaction> transactions = session
					.createCriteria(Transaction.class).add(Restrictions.and(criterion1, criterion2))
					.addOrder(Order.desc("title")).list();

			for (Transaction t : transactions) {
				System.out.println(t.getTitle());
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			factory.close();
		}
	}
}
