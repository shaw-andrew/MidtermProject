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

class EquipmentTypeTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private EquipmentType equipmentType;

	
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
		equipmentType = em.find(EquipmentType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		equipmentType = null;
		
	}
	
	@Test
	void test_Equipment_Type_entity_mapping() {
		assertNotNull(equipmentType);
		assertEquals("mechanical", equipmentType.getName());
	}
	
	@Test
	void test_Equipment_Type_to_Equipment() {
		assertNotNull(equipmentType);
		assertTrue( equipmentType.getEquipment() != null &&equipmentType.getEquipment().size() >0);
	}

	@Test
	void test_Equipment_Type_to_Staff_Supervisor() {
		assertNotNull(equipmentType);
		assertTrue( equipmentType.getMrc() != null &&equipmentType.getMrc().size() >0);
	}
	

}
