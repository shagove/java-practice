package ee.sda.hibernate;

import java.util.Date;

import ee.sda.hibernate.entities.Bank;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApplicationCollection {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Bank bank = new Bank();
		bank.setName("Federal Trust");
		bank.setAddressLine1("33 Wall Street");
		bank.setAddressLine2("Suite 302");
		bank.setCity("New York");
		bank.setState("NY");
		bank.setZipCode("27914");
		bank.setCreatedBy("pepo");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("pepo");
		bank.setLastUpdatedDate(new Date());
//		bank.getContacts().add("Joe");
//		bank.getContacts().add("Mary");
		bank.getContacts().put("MANAGER","Joe");
		bank.getContacts().put("TELLER","Mary");

		session.save(bank);
		transaction.commit();

	}

}
