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
		assertEquals(1, location.getId());
		assertEquals("123 A St.", location.getStreet());
		assertEquals("Denver", location.getCity());
		assertEquals("CO", location.getStateAbbrev());
		assertEquals(80205, location.getZipCode());
	}
	
	@Test
	void test_Location_To_Staff_entity_mapping() {
		assertNotNull(location);
		assertEquals(2, location.getStaff().size());
	}
	
	@Test
	void test_Location_To_Equipment_entity_mapping() {
		assertNotNull(location);
	}

}
