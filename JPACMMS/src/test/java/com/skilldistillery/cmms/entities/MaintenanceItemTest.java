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

class MaintenanceItemTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private MaintenanceItem maintenanceItem;

	
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
		maintenanceItem = em.find(MaintenanceItem.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		maintenanceItem = null;
		
	}
	
	@Test
	void test_Maintenance_Item_entity_mapping() {
		assertNotNull(maintenanceItem);
	}
	
	@Test
	void test_Maintenance_Item_to_Staff() {
		assertNotNull(maintenanceItem);
		assertEquals("Jane", maintenanceItem.getStaff().getFirstName());
	}

	@Test
	void test_Maintenance_Item_To_MRC() {
		assertNotNull(maintenanceItem);
		assertEquals("test maintenance", maintenanceItem.getMrc().getDescription());
	}
	
}
