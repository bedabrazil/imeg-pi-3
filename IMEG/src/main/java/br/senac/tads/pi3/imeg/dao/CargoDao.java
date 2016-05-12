/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
public class CargoDao {

    private PreparedStatement pst;

    public boolean adicionar(Cargo cargo) {
        String sql = "INSERT INTO CARGOS(NOME, STATUS, ACESSOS_ID)VALUES(?,?,?)";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, cargo.getNome());
            pst.setBoolean(2, cargo.isStatus());
            pst.setInt(3, cargo.getAcesso().getId());
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

    public boolean alterar(Cargo cargo) {
        String sql = "UPDATE CARGOS SET NOME=?, STATUS=?, ACESSOS_ID=? WHERE ID=?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, cargo.getNome());
            pst.setBoolean(2, cargo.isStatus());
            pst.setInt(3, cargo.getAcesso().getId());
            pst.setInt(4, cargo.getId());
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

    public ArrayList<Cargo> listar() {
        String sql = "SELECT CARGOS.* FROM CARGOS ORDER BY ID DESC";
        try {
            ArrayList<Cargo> cargos = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(res.getInt("ID"));
                cargo.setNome(res.getString("NOME"));
                cargo.setStatus(res.getBoolean("STATUS"));
                cargo.setAcesso(new AcessoDao().pesquisarPorId(res.getInt("ACESSOS_ID")));
                cargos.add(cargo);
            }
            return cargos;
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
    public Cargo pesquisarPorId(int id){
        String sql = "SELECT CARGOS.* FROM CARGOS WHERE ID=?";
        try{
            Cargo cargo = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                cargo =  new Cargo();
                cargo.setId(res.getInt("ID"));
                cargo.setNome(res.getString("NOME"));
                cargo.setStatus(res.getBoolean("STATUS"));
                cargo.setAcesso(new AcessoDao().pesquisarPorId(res.getInt("ACESSOS_ID")));
            }
            return cargo;
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
    public boolean remover(Cargo cargo){
        String sql = "DELETE FROM CARGOS WHERE ID=?";
        try{
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, cargo.getId());
            if(pst.executeUpdate() > 0){
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
}
