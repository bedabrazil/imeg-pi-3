/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
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
public class HistoricoEntradaDaoTest {
    
    public HistoricoEntradaDaoTest() {
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
     * Test of incluirHistoricoEntrada method, of class HistoricoEntradaDao.
     */
    @Test
    public void testIncluirHistoricoEntrada() {
        System.out.println("incluirHistoricoEntrada");
        HistoricoEntrada historicoEntrada = null;
        HistoricoEntradaDao instance = new HistoricoEntradaDao();
        instance.incluirHistoricoEntrada(historicoEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarHistoricoEntrada method, of class HistoricoEntradaDao.
     */
    @Test
    public void testConsultarHistoricoEntrada() {
        System.out.println("consultarHistoricoEntrada");
        HistoricoEntrada historicoEntrada = null;
        HistoricoEntradaDao instance = new HistoricoEntradaDao();
        instance.consultarHistoricoEntrada(historicoEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarHistoricoEntrada method, of class HistoricoEntradaDao.
     */
    @Test
    public void testAlterarHistoricoEntrada() {
        System.out.println("alterarHistoricoEntrada");
        HistoricoEntrada historicoEntrada = null;
        HistoricoEntradaDao instance = new HistoricoEntradaDao();
        instance.alterarHistoricoEntrada(historicoEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerHistoricoEntrada method, of class HistoricoEntradaDao.
     */
    @Test
    public void testRemoverHistoricoEntrada() {
        System.out.println("removerHistoricoEntrada");
        HistoricoEntrada historicoEntrada = null;
        HistoricoEntradaDao instance = new HistoricoEntradaDao();
        instance.removerHistoricoEntrada(historicoEntrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
