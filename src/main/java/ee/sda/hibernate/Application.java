package ee.sda.hibernate;

import java.util.Calendar;
import java.util.Date;

import ee.sda.hibernate.entities.User;
import org.hibernate.Session;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1969);
		calendar.set(Calendar.MONTH, 8);;
		calendar.set(Calendar.DATE, 29);;
		user.setBirthDate(calendar.getTime());
		user.setCreatedBy("pepo");
		user.setCreatedDate(new Date());
		user.setEmailAddress("pepo@gmail.com");
		user.setFirstName("pepo");
		user.setLastName("martinez");
		user.setLastUpdatedBy("pepo");
		user.setLastUpdatedDate(new Date());
		session.save(user);
		session.getTransaction().commit();
		session.refresh(user);
		System.out.println(user.getAge());

//		session.beginTransaction();
//		User dbUser = (User)session.get(User.class, user.getUserId());
//		dbUser.setFirstName("Joe");
//		session.update(dbUser);
//		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
//		session.close();

	}

}
