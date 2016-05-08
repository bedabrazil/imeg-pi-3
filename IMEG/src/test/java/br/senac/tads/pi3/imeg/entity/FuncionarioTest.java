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
public class FuncionarioTest {
    
    public FuncionarioTest() {
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
     * Test of getId method, of class Funcionario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Funcionario instance = new Funcionario();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Funcionario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Funcionario instance = new Funcionario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCargo method, of class Funcionario.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        Funcionario instance = new Funcionario();
        Cargo expResult = null;
        Cargo result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCargo method, of class Funcionario.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        Cargo cargo = null;
        Funcionario instance = new Funcionario();
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUnidade method, of class Funcionario.
     */
    @Test
    public void testGetUnidade() {
        System.out.println("getUnidade");
        Funcionario instance = new Funcionario();
        Unidade expResult = null;
        Unidade result = instance.getUnidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUnidade method, of class Funcionario.
     */
    @Test
    public void testSetUnidade() {
        System.out.println("setUnidade");
        Unidade unidade = null;
        Funcionario instance = new Funcionario();
        instance.setUnidade(unidade);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNome method, of class Funcionario.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Funcionario instance = new Funcionario();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNome method, of class Funcionario.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Funcionario instance = new Funcionario();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class Funcionario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Funcionario instance = new Funcionario();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class Funcionario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Funcionario instance = new Funcionario();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSenhaHash method, of class Funcionario.
     */
    @Test
    public void testGetSenhaHash() {
        System.out.println("getSenhaHash");
        Funcionario instance = new Funcionario();
        char[] expResult = null;
        char[] result = instance.getSenhaHash();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setSenhaHash method, of class Funcionario.
     */
    @Test
    public void testSetSenhaHash() {
        System.out.println("setSenhaHash");
        char[] senhaHash = null;
        Funcionario instance = new Funcionario();
        instance.setSenhaHash(senhaHash);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
