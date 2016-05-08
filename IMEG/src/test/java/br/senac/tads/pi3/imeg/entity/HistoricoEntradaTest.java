/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.entity;

import java.util.Date;
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
public class HistoricoEntradaTest {
    
    public HistoricoEntradaTest() {
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
     * Test of getId method, of class HistoricoEntrada.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        HistoricoEntrada instance = new HistoricoEntrada();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getData_transacao method, of class HistoricoEntrada.
     */
    @Test
    public void testGetData_transacao() {
        System.out.println("getData_transacao");
        HistoricoEntrada instance = new HistoricoEntrada();
        Date expResult = null;
        Date result = instance.getData_transacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setData_transacao method, of class HistoricoEntrada.
     */
    @Test
    public void testSetData_transacao() {
        System.out.println("setData_transacao");
        Date data_transacao = null;
        HistoricoEntrada instance = new HistoricoEntrada();
        instance.setData_transacao(data_transacao);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getQtde_produtos method, of class HistoricoEntrada.
     */
    @Test
    public void testGetQtde_produtos() {
        System.out.println("getQtde_produtos");
        HistoricoEntrada instance = new HistoricoEntrada();
        int expResult = 0;
        int result = instance.getQtde_produtos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setQtde_produtos method, of class HistoricoEntrada.
     */
    @Test
    public void testSetQtde_produtos() {
        System.out.println("setQtde_produtos");
        int qtde_produtos = 0;
        HistoricoEntrada instance = new HistoricoEntrada();
        instance.setQtde_produtos(qtde_produtos);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getProduto method, of class HistoricoEntrada.
     */
    @Test
    public void testGetProduto() {
        System.out.println("getProduto");
        HistoricoEntrada instance = new HistoricoEntrada();
        Produto expResult = null;
        Produto result = instance.getProduto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getFuncionario method, of class HistoricoEntrada.
     */
    @Test
    public void testGetFuncionario() {
        System.out.println("getFuncionario");
        HistoricoEntrada instance = new HistoricoEntrada();
        Funcionario expResult = null;
        Funcionario result = instance.getFuncionario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
