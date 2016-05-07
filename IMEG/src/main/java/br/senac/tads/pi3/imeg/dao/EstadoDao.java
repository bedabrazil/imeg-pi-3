/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Estado;
import br.senac.tads.pi3.imeg.entity.Unidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iosato
 */
public class EstadoDao {
    
    private PreparedStatement pst;
    
    public ArrayList<Estado> listar() {
        String sql = "SELECT * FROM ESTADOS";
        try {
            ArrayList<Estado> estados = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Estado estado = new Estado();
                
                estado.setId(res.getInt("ID"));              
                estado.setNome(res.getString("NOME"));
                estados.add(estado);
            }
            return estados;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public Estado pesquisarPorId(int id){
        String sql = "SELECT * FROM ESTADOS WHERE ID=?;";
        try{
            Estado estado = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                estado =  new Estado();
                
                estado.setId(res.getInt("ID"));
                estado.setNome(res.getString("NOME"));
            }
            return estado;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
}
