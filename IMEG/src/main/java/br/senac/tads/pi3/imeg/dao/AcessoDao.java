/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Acesso;
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
public class AcessoDao {

    PreparedStatement pst;

    public boolean adicionar(Acesso acesso) {
        String sql = "INSERT INTO ACESSOS (NOME, STATUS)VALUES(?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, acesso.getNome());
            pst.setBoolean(2, acesso.isStatus());
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

    public ArrayList<Acesso> listar() {
        String sql = "SELECT ACESSOS.* FROM ACESSOS";
        try {
            ArrayList<Acesso> acessos = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Acesso acesso = new Acesso();
                acesso.setId(res.getInt("ID"));
                acesso.setNome(res.getString("NOME"));
                acesso.setStatus(res.getBoolean("STATUS"));
                acessos.add(acesso);
            }
            return acessos;
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

    public Acesso pesquisarPorId(int id) {
        String sql = "SELECT ACESSOS.* FROM ACESSOS WHERE ID=?";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            Acesso acesso = null;
            while (res.next()) {
                acesso = new Acesso();
                acesso.setId(res.getInt("ID"));
                acesso.setNome(res.getString("NOME"));
                acesso.setStatus(res.getBoolean("STATUS"));
            }
            return acesso;
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

    public Acesso pesquisarPorNome(Acesso access) {
        String sql = "SELECT  FROM ACESSOS WHERE NOME LIKE '%?%'";
        try {
            Acesso acesso = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, access.getNome());
            ResultSet res = pst.executeQuery();
            if(res.next()){
                acesso = new Acesso();
                acesso.setId(res.getInt("ID"));
                acesso.setNome(res.getString("NOME"));
                acesso.setStatus(res.getBoolean("STATUS"));
            }
            return acesso;
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
