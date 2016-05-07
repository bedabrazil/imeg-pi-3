/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eilane
 */
public class FuncionarioDao {

    private PreparedStatement pst;

    public void incluirFuncionario(Funcionario funcionario) {

        String sql = "INSERT INTO FUNCIONARIOS "
                + "(CARGOS_ID, UNIDADES_ID, NOME)"
                + "VALUES (?, ?, ?)";
        try {
            pst = new Conexao().prepararStatement(sql);
//            stmt.setInt(1, funcionario.getIdcargo());
//            stmt.setInt(2, funcionario.getIdunidade());
            pst.setInt(1, funcionario.getCargo_id());
            pst.setInt(2, funcionario.getUnidades_id());
            pst.setString(3, funcionario.getNome());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean alterarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE Funcionarios SET CARGOS_ID=?,UNIDADES_ID=?, NOME=?"
                + "WHERE ID = ?";
        // UPDATE

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getCargo_id());
            pst.setInt(2, funcionario.getUnidades_id());
            pst.setString(3, funcionario.getNome());
            pst.setInt(4, funcionario.getId());
            
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
    public ArrayList<Funcionario> consultarProduto(String pesquisa, String categoria ) {
        String sql = "SELECT  FROM funcionarios WHERE '"+categoria+"' LIKE '" + pesquisa + "%';";
        ArrayList<Funcionario> tempFuncionarios = new ArrayList<>();

        try {
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCargo_id(rs.getInt("CARGOS_ID"));
                funcionario.setUnidades_id(rs.getInt("UNIDADES_ID"));
                funcionario.setNome(rs.getString("nome"));
                tempFuncionarios.add(funcionario);

            }
            return tempFuncionarios;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
