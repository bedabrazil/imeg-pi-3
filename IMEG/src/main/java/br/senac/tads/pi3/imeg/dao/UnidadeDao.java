/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Unidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mssouza
 */
public class UnidadeDao {
    
    private PreparedStatement pst;

    public boolean adicionar(Unidade unidade) {
        String sql = "INSERT INTO UNIDADES(NOME)VALUES(?);";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, unidade.getNome());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    public boolean alterar(Unidade unidade) {
        String sql = "UPDATE UNIDADES SET NOME=? WHERE ID=?;";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, unidade.getNome());
            pst.setInt(3, unidade.getId());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    public ArrayList<Unidade> listar() {
        String sql = "SELECT * FROM UNIDADES";
        try {
            ArrayList<Unidade> unidades = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Unidade unidade = new Unidade();
                EstadoDao estadoDao = new EstadoDao();
                
                unidade.setId(res.getInt("ID"));
                unidade.setEstado(estadoDao.pesquisarPorId(res.getInt("ESTADOS_ID")));
                unidade.setNome(res.getString("NOME"));
                unidades.add(unidade);
            }
            return unidades;
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
    
    public Unidade pesquisarPorId(int id){
        String sql = "SELECT UNIDADES.* FROM UNIDADES WHERE ID=?";
        try{
            Unidade unidade = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                unidade =  new Unidade();
                unidade.setId(res.getInt("ID"));
                unidade.setEstado(new EstadoDao().pesquisarPorId(res.getInt("ESTADOS_ID")));
                unidade.setNome(res.getString("NOME"));
            }
            return unidade;
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
