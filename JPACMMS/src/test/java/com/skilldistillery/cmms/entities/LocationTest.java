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

class LocationTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Location location;

	
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
		location = em.find(Location.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		location = null;
		
	}
	
	@Test
	void test_Location_entity_mapping() {
		assertNotNull(location);
		assertEquals("123 A St.", location.getStreet());
	}
	
	@Test
	void test_Location_to_Staff() {
		assertNotNull(location);
		assertTrue( location.getStaff() != null &&location.getStaff().size() >0);
	}

	@Test
	void test_Location_to_Staff_Supervisor() {
		assertNotNull(location);
		assertTrue( location.getSupervisingStaff() != null &&location.getSupervisingStaff().size() >0);
	}
	
}
