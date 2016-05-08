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
public class AcessoTest {
    
    public AcessoTest() {
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
     * Test of isStatus method, of class Acesso.
     */
    @Test
    public void testIsStatus() {
        Acesso instance = new Acesso();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class Acesso.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = true;
        Acesso instance = new Acesso();
        instance.setStatus(status);
        assertEquals(status, instance.isStatus());
    }

    /**
     * Test of getId method, of class Acesso.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Acesso instance = new Acesso();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Acesso.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Acesso instance = new Acesso();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getNome method, of class Acesso.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Acesso instance = new Acesso();
        String expResult = null;
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Acesso.
     */
    @Test
    public void testSetNome() {
        String nome = "MARCIO";
        Acesso instance = new Acesso();
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }
    
}
