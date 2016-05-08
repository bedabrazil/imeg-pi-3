/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Cargo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author developer
 */
public class CargoDaoTest {
    
    public CargoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of adicionar method, of class CargoDao.
     */
    @Test
    public void testAdicionar() {
        System.out.println("adicionar");
        Cargo cargo = null;
        CargoDao instance = new CargoDao();
        boolean expResult = false;
        boolean result = instance.adicionar(cargo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class CargoDao.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Cargo cargo = null;
        CargoDao instance = new CargoDao();
        boolean expResult = false;
        boolean result = instance.alterar(cargo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class CargoDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        CargoDao instance = new CargoDao();
        ArrayList<Cargo> expResult = null;
        ArrayList<Cargo> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class CargoDao.
     */
    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        int id = 0;
        CargoDao instance = new CargoDao();
        Cargo expResult = null;
        Cargo result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
