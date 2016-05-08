/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import java.sql.PreparedStatement;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author developer
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    

    /**
     * Test of prepararStatement method, of class Conexao.
     */
    @Test
    public void testPrepararStatement() {
        System.out.println("prepararStatement");
        String sql = "";
        Conexao instance = new Conexao();
        PreparedStatement expResult = null;
        PreparedStatement result = instance.prepararStatement(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
