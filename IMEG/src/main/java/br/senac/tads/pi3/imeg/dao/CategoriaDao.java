/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogo.lsousa
 */
public class CategoriaDao {

    private PreparedStatement pst;

    public boolean incluirCategoria(Categoria categoria) {

        String sql = "INSERT INTO CATEGORIAS(NOME, STATUS) VALUES(?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.setBoolean(2, categoria.isStatus());

            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<Categoria> consultarCategoria(Categoria categoria) {

        String sql = "SELECT * FROM CATEGORIAS WHERE NOME LIKE '%" + categoria.getNome() + "%';";
        ArrayList<Categoria> listaCategoria = new ArrayList<>();

        try {
            
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                categoria.setNome(rs.getString("NOME"));
                categoria.setStatus(rs.getBoolean("STATUS"));

                listaCategoria.add(categoria);
            }
            return listaCategoria;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
               pst.close();
                
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public void alterarCategoria(Categoria categoria) {
        String sql = "SELECT * FROM CATEGORIAS WHERE ID ='"+ categoria.getId()+"'";
        
        try {       
        pst= new Conexao().prepararStatement(sql);
        ResultSet rs = pst.executeQuery(sql);
        
        pst.setString(1, categoria.getNome());
        pst.setBoolean(2, categoria.isStatus());
              
         } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: "+ex.getMessage());
         }finally{
            try {
                pst.close();
            } catch (SQLException ex) {
            }
        }

    }

    public void removerCategoria(Categoria categoria) {

    }

}
