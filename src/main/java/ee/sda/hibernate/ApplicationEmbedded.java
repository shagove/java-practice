package ee.sda.hibernate;

import java.util.Date;

import ee.sda.hibernate.entities.Address;
import ee.sda.hibernate.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApplicationEmbedded {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		Address address = new Address();
		Address address2 = new Address();

		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("pepo");
		user.setCreatedDate(new Date());
		user.setEmailAddress("pepo@gmail.com");
		user.setFirstName("pepo");
		user.setLastName("martinez");
		user.setLastUpdatedBy("jose");
		user.setLastUpdatedDate(new Date());

		address.setAddressLine1("linea 3");
		address.setAddressLine2("linea 4");
		address.setCity("avila");
		address.setState("pa");
		address.setZipCode("12345");

		address2.setAddressLine1("linea 5");
		address2.setAddressLine2("linea 6");
		address2.setCity("avila");
		address2.setState("pa");
		address2.setZipCode("12345");


//		user.setAddress(address);
		user.getAddresses().add(address);
		user.getAddresses().add(address2);
		session.save(user);
		transaction.commit();
		session.close();

	}

}
