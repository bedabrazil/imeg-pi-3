/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
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
public class FuncionarioDaoTest {
    
    public FuncionarioDaoTest() {
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
     * Test of incluirFuncionario method, of class FuncionarioDao.
     */
    @Test
    public void testIncluirFuncionario() {
        System.out.println("incluirFuncionario");
        Funcionario funcionario = null;
        FuncionarioDao instance = new FuncionarioDao();
        instance.incluirFuncionario(funcionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarFuncionario method, of class FuncionarioDao.
     */
    @Test
    public void testAlterarFuncionario() {
        System.out.println("alterarFuncionario");
        Funcionario funcionario = null;
        FuncionarioDao instance = new FuncionarioDao();
        boolean expResult = false;
        boolean result = instance.alterarFuncionario(funcionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarFuncionarioPorNome method, of class FuncionarioDao.
     */
    @Test
    public void testConsultarFuncionarioPorNome() {
        System.out.println("consultarFuncionarioPorNome");
        String nomeFuncionario = "";
        FuncionarioDao instance = new FuncionarioDao();
        ArrayList<Funcionario> expResult = null;
        ArrayList<Funcionario> result = instance.consultarFuncionarioPorNome(nomeFuncionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
