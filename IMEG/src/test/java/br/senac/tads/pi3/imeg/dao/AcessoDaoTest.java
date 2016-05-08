/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Acesso;
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
public class AcessoDaoTest {
    
    public AcessoDaoTest() {
    }
    

    /**
     * Test of adicionar method, of class AcessoDao.
     */
    @Test
    public void testAdicionar() {
        System.out.println("adicionar");
        Acesso acesso = new Acesso();
        AcessoDao instance = new AcessoDao();
        boolean expResult = false;
        boolean result = instance.adicionar(acesso);
        assertEquals(expResult, result);
    }

    /**
     * Test of listar method, of class AcessoDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        AcessoDao instance = new AcessoDao();
        ArrayList<Acesso> expResult = instance.listar();
        ArrayList<Acesso> result = instance.listar();
        
        assertEquals(expResult.size(), result.size());
        assertEquals("ADMIN", result.get(0).getNome());
        assertEquals("GERENTE", result.get(1).getNome());
        assertEquals("ANALISTA", result.get(2).getNome());
        assertEquals("ATENDENTE", result.get(3).getNome());
        
    }

    /**
     * Test of pesquisarPorId method, of class AcessoDao.
     */
    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        int id = 1000;
        AcessoDao instance = new AcessoDao();
        Acesso expResult = null;
        Acesso result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of pesquisarPorNome method, of class AcessoDao.
     */
    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        Acesso access = new Acesso("ADMIN", true);
        AcessoDao instance = new AcessoDao();
        Acesso expResult = new Acesso("ADMIN", true);
        Acesso result = instance.pesquisarPorNome(access);
        
        assertEquals(expResult.getNome(), result.getNome());
    }
    
}
