package com.skilldistillery.cmms.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Part part;

	
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
		part = em.find(Part.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		part = null;
		
	}
	
	@Test
	void test_User_entity_mapping() {
		assertNotNull(part);
		assertEquals(5.99, part.getCost());
	}

}
