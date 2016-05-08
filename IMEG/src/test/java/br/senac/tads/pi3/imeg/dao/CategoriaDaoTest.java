/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
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
public class CategoriaDaoTest {
    
    public CategoriaDaoTest() {
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
     * Test of incluirCategoria method, of class CategoriaDao.
     */
    @Test
    public void testIncluirCategoria() {
        System.out.println("incluirCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        boolean expResult = false;
        boolean result = instance.incluirCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarCategoria method, of class CategoriaDao.
     */
    @Test
    public void testEditarCategoria() {
        System.out.println("editarCategoria");
        int id = 0;
        CategoriaDao instance = new CategoriaDao();
        Categoria expResult = null;
        Categoria result = instance.editarCategoria(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarCategoria method, of class CategoriaDao.
     */
    @Test
    public void testConsultarCategoria() {
        System.out.println("consultarCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.consultarCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarCategoria method, of class CategoriaDao.
     */
    @Test
    public void testAlterarCategoria() {
        System.out.println("alterarCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        boolean expResult = false;
        boolean result = instance.alterarCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerCategoria method, of class CategoriaDao.
     */
    @Test
    public void testRemoverCategoria() {
        System.out.println("removerCategoria");
        Categoria categoria = null;
        CategoriaDao instance = new CategoriaDao();
        instance.removerCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class CategoriaDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        CategoriaDao instance = new CategoriaDao();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
