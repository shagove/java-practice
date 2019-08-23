package ee.sda.hibernate;

import java.util.Date;

import ee.sda.hibernate.entities.TimeTest;
import org.hibernate.Session;

public class ApplicationTemporal {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			TimeTest test = new TimeTest(new Date());
			session.save(test);
			session.getTransaction().commit();

			session.refresh(test);

			System.out.println(test.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

}