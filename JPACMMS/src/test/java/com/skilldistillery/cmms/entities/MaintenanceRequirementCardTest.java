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

class MaintenanceRequirementCardTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private MaintenanceRequirementCard mrc;

	
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
		mrc = em.find(MaintenanceRequirementCard.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		mrc = null;
		
	}
	
	@Test
	void test_MaintenanceRequirementCard_entity_mapping() {
		assertNotNull(mrc);
		assertEquals("test maintenance", mrc.getDescription());
	}
	
	@Test
	void test_MRC_to_Frequency() {
		assertNotNull(mrc);
		assertEquals("daily", mrc.getFrequency().getName());
	}
	
	@Test
	void test_mrc_tool_many_to_many_mapping() {
		assertNotNull(mrc);
		assertNotNull(mrc.getTools());
		assertTrue(mrc.getTools().size() > 0);
	}
	
	@Test
	void test_mrc_part_many_to_many_mapping() {
		assertNotNull(mrc);
		assertNotNull(mrc.getParts());
		assertTrue(mrc.getParts().size() > 0);
	}

	@Test
	void test_mrc_safety_many_to_many_mapping() {
		assertNotNull(mrc);
		assertNotNull(mrc.getSafety());
		assertTrue(mrc.getSafety().size() > 0);
	}
	
	@Test
	void test_mrc_certification_many_to_many_mapping() {
		assertNotNull(mrc);
		assertNotNull(mrc.getCertifications());
		assertTrue(mrc.getCertifications().size() > 0);
	}
	
}
