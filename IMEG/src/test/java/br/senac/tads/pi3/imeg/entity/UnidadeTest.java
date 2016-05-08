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
public class UnidadeTest {
    
    public UnidadeTest() {
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
     * Test of getId method, of class Unidade.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Unidade instance = new Unidade();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setId method, of class Unidade.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Unidade instance = new Unidade();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEstado method, of class Unidade.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Unidade instance = new Unidade();
        Estado expResult = null;
        Estado result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNome method, of class Unidade.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Unidade instance = new Unidade();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEstado method, of class Unidade.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Estado estado = null;
        Unidade instance = new Unidade();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNome method, of class Unidade.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Unidade instance = new Unidade();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
