/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author diogo.lsousa
 */
public class CategoriaDao {

    public void incluirCategoria(Categoria categoria) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO CATEGORIA(NOME, STATUS) VALUES(?,?)";

        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoria.getNome());
            stmt.setBoolean(2, categoria.isStatus());

            
                stmt.execute();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    public void consultarCategoria(Categoria categoria){
    
    }
    
    public void alterarCategoria(Categoria categoria){
    
    }
    
    public void removerCategoria(Categoria categoria){
    
    }
    
 

}
