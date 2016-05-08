/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

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
public class CargoTest {
    
    public CargoTest() {
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
     * Test of getId method, of class Cargo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Cargo instance = new Cargo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Cargo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Cargo instance = new Cargo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNome method, of class Cargo.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Cargo instance = new Cargo();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNome method, of class Cargo.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Cargo instance = new Cargo();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isStatus method, of class Cargo.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        Cargo instance = new Cargo();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStatus method, of class Cargo.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = false;
        Cargo instance = new Cargo();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAcesso method, of class Cargo.
     */
    @Test
    public void testGetAcesso() {
        System.out.println("getAcesso");
        Cargo instance = new Cargo();
        Acesso expResult = null;
        Acesso result = instance.getAcesso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAcesso method, of class Cargo.
     */
    @Test
    public void testSetAcesso() {
        System.out.println("setAcesso");
        Acesso acesso = null;
        Cargo instance = new Cargo();
        instance.setAcesso(acesso);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
