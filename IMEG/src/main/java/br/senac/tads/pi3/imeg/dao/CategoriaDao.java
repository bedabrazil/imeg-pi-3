/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogo.lsousa
 */
public class CategoriaDao {
    private PreparedStatement pst;
    public void incluirCategoria(Categoria categoria) {

        String sql = "INSERT INTO CATEGORIA(NOME, STATUS) VALUES(?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, categoria.getNome());
            pst.setBoolean(2, categoria.isStatus());

            
                pst.execute();
            } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    
    
    
    public void consultarCategoria(Categoria categoria){
    
    }
    
    public void alterarCategoria(Categoria categoria){
    
    }
    
    public void removerCategoria(Categoria categoria){
    
    }
    
 

}
