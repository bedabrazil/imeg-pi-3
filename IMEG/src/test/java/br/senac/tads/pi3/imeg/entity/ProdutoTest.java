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
public class ProdutoTest {
    
    public ProdutoTest() {
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
     * Test of getId method, of class Produto.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Produto instance = new Produto();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNome method, of class Produto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Produto instance = new Produto();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNome method, of class Produto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Produto instance = new Produto();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrecoCusto method, of class Produto.
     */
    @Test
    public void testGetPrecoCusto() {
        System.out.println("getPrecoCusto");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getPrecoCusto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPrecoCusto method, of class Produto.
     */
    @Test
    public void testSetPrecoCusto() {
        System.out.println("setPrecoCusto");
        double precoCusto = 0.0;
        Produto instance = new Produto();
        instance.setPrecoCusto(precoCusto);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrecoVenda method, of class Produto.
     */
    @Test
    public void testGetPrecoVenda() {
        System.out.println("getPrecoVenda");
        Produto instance = new Produto();
        double expResult = 0.0;
        double result = instance.getPrecoVenda();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPrecoVenda method, of class Produto.
     */
    @Test
    public void testSetPrecoVenda() {
        System.out.println("setPrecoVenda");
        double precoVenda = 0.0;
        Produto instance = new Produto();
        instance.setPrecoVenda(precoVenda);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getQtdeMin method, of class Produto.
     */
    @Test
    public void testGetQtdeMin() {
        System.out.println("getQtdeMin");
        Produto instance = new Produto();
        int expResult = 0;
        int result = instance.getQtdeMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setQtdeMin method, of class Produto.
     */
    @Test
    public void testSetQtdeMin() {
        System.out.println("setQtdeMin");
        int qtdeMin = 0;
        Produto instance = new Produto();
        instance.setQtdeMin(qtdeMin);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getQtdeMax method, of class Produto.
     */
    @Test
    public void testGetQtdeMax() {
        System.out.println("getQtdeMax");
        Produto instance = new Produto();
        int expResult = 0;
        int result = instance.getQtdeMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setQtdeMax method, of class Produto.
     */
    @Test
    public void testSetQtdeMax() {
        System.out.println("setQtdeMax");
        int qtdeMax = 0;
        Produto instance = new Produto();
        instance.setQtdeMax(qtdeMax);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSaldo method, of class Produto.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        Produto instance = new Produto();
        int expResult = 0;
        int result = instance.getSaldo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSaldo method, of class Produto.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        int saldo = 0;
        Produto instance = new Produto();
        instance.setSaldo(saldo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isStatus method, of class Produto.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        Produto instance = new Produto();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setStatus method, of class Produto.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = false;
        Produto instance = new Produto();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCategoria method, of class Produto.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Produto instance = new Produto();
        Categoria expResult = null;
        Categoria result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCategoria method, of class Produto.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        Categoria categoria = null;
        Produto instance = new Produto();
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
