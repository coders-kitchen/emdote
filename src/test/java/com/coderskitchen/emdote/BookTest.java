package com.coderskitchen.emdote;

import com.coderskitchen.emdote.docker.Docker;
import com.coderskitchen.emdote.docker.model.Container;
import com.coderskitchen.emdote.model.Book;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Properties;

public class BookTest {

	public static final String IMAGE_NAME = "eg_postgresql";

	@Test
	public void testSomeLibraryMethod() throws Exception {
		Container container = Docker.run(IMAGE_NAME);

		String ipAddress = Docker.getIpOfContainer(container);

		EntityManager entityManager = createEntityManager(ipAddress);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Book book = new Book();
			book.setName("Peter Pan");
			entityManager.persist(book);
			book = new Book();
			book.setName("Momo");
			entityManager.persist(book);

		} finally {
			transaction.commit();
			Docker.stop(container);
		}

	}

	private EntityManager createEntityManager(String ipAddress) {
		Properties properties = new Properties();
		properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://" + ipAddress + "/docker");
		properties.put("javax.persistence.jdbc.user", "docker");
		properties.put("javax.persistence.jdbc.password", "docker");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU", properties);
		return emf.createEntityManager();
	}
}
