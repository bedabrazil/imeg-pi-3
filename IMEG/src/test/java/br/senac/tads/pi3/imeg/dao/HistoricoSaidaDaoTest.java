/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoSaida;
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
public class HistoricoSaidaDaoTest {
    
    public HistoricoSaidaDaoTest() {
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
     * Test of incluirHistoricoSaida method, of class HistoricoSaidaDao.
     */
    @Test
    public void testIncluirHistoricoSaida() {
        System.out.println("incluirHistoricoSaida");
        HistoricoSaida historicoSaida = null;
        HistoricoSaidaDao instance = new HistoricoSaidaDao();
        instance.incluirHistoricoSaida(historicoSaida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarHistoricoSaida method, of class HistoricoSaidaDao.
     */
    @Test
    public void testConsultarHistoricoSaida() {
        System.out.println("consultarHistoricoSaida");
        HistoricoSaida historicoSaida = null;
        HistoricoSaidaDao instance = new HistoricoSaidaDao();
        instance.consultarHistoricoSaida(historicoSaida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarHistoricoSaida method, of class HistoricoSaidaDao.
     */
    @Test
    public void testAlterarHistoricoSaida() {
        System.out.println("alterarHistoricoSaida");
        HistoricoSaida historicoSaida = null;
        HistoricoSaidaDao instance = new HistoricoSaidaDao();
        instance.alterarHistoricoSaida(historicoSaida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerHistoricoSaida method, of class HistoricoSaidaDao.
     */
    @Test
    public void testRemoverHistoricoSaida() {
        System.out.println("removerHistoricoSaida");
        HistoricoSaida historicoSaida = null;
        HistoricoSaidaDao instance = new HistoricoSaidaDao();
        instance.removerHistoricoSaida(historicoSaida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
