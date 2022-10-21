package com.skilldistillery.cmms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CertificationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Certification certification;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACMMS");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();

	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		certification = em.find(Certification.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		certification = null;

	}

	@Test
	void test_User_entity_mapping() {
		assertNotNull(certification);
		assertEquals("general maintenance", certification.getName());
	}

}
