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
public class EstadoTest {
    
    public EstadoTest() {
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
     * Test of getId method, of class Estado.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Estado instance = new Estado();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Estado.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Estado instance = new Estado();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNome method, of class Estado.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Estado instance = new Estado();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNome method, of class Estado.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Estado instance = new Estado();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
