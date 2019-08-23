package ee.sda.hibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ee.sda.hibernate.entities.Bank;

public class Application2CompoundPrimaryKeys {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("infinite-finances");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx =  em.getTransaction();
		tx.begin();

		Bank bank = createBank();

		em.persist(bank);

		tx.commit();

		em.close();
		emf.close();

	}

	private static Bank createBank() {
		Bank bank = new Bank();
		bank.setName("First United Federal");
		bank.setAddressLine1("103 Washington Plaza");
		bank.setAddressLine2("Suite 332");
		bank.setAddressType("PRIMARY");
		bank.setCity("New York");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipCode("10000");
		return bank;
	}

}
