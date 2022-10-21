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

class TrainingTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Training training;

	
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
		training = em.find(Training.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		training = null;
		
	}
	
	@Test
	void test_Training_entity_mapping() {
		assertNotNull(training);
		assertEquals("general", training.getCategory());
	}

}
