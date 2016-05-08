/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Produto;
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
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
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
     * Test of cadastrarProduto method, of class ProdutoDAO.
     */
    @Test
    public void testCadastrarProduto() {
        System.out.println("cadastrarProduto");
        Produto produto = null;
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = false;
        boolean result = instance.cadastrarProduto(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarProduto method, of class ProdutoDAO.
     */
    @Test
    public void testConsultarProduto() {
        System.out.println("consultarProduto");
        String pesquisa = "";
        String categoria = "";
        ProdutoDAO instance = new ProdutoDAO();
        ArrayList<Produto> expResult = null;
        ArrayList<Produto> result = instance.consultarProduto(pesquisa, categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarProduto method, of class ProdutoDAO.
     */
    @Test
    public void testAlterarProduto() {
        System.out.println("alterarProduto");
        int codigo = 0;
        Produto produto = null;
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = false;
        boolean result = instance.alterarProduto(codigo, produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
