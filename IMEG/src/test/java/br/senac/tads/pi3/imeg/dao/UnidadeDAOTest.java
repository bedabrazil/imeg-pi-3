/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Unidade;
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
public class UnidadeDAOTest {
    
    public UnidadeDAOTest() {
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
     * Test of adicionar method, of class UnidadeDAO.
     */
    @Test
    public void testAdicionar() {
        System.out.println("adicionar");
        Unidade unidade = null;
        UnidadeDAO instance = new UnidadeDAO();
        boolean expResult = false;
        boolean result = instance.adicionar(unidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class UnidadeDAO.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Unidade unidade = null;
        UnidadeDAO instance = new UnidadeDAO();
        boolean expResult = false;
        boolean result = instance.alterar(unidade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class UnidadeDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        UnidadeDAO instance = new UnidadeDAO();
        ArrayList<Unidade> expResult = null;
        ArrayList<Unidade> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class UnidadeDAO.
     */
    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        int id = 0;
        UnidadeDAO instance = new UnidadeDAO();
        Unidade expResult = null;
        Unidade result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
