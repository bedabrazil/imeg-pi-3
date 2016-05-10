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

    //Cadastra um novo funcionario
    public void incluirFuncionario(Funcionario funcionario) {

        String sql = "INSERT INTO FUNCIONARIOS "
                + "(CARGOS_ID, UNIDADES_ID, NOME)"
                + "VALUES (?, ?, ?)";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getCargo().getId());
            pst.setInt(2, funcionario.getUnidade().getId());
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
    
    //Altera informações de um funcionário
    public boolean alterarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE Funcionarios SET CARGOS_ID=?,UNIDADES_ID=?, NOME=?"
                + "WHERE ID = ?";
        // UPDATE

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getCargo().getId());
            pst.setInt(2, funcionario.getUnidade().getId());
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
    
    //Lista funcionarios com um nome passado por parâmetro
    public ArrayList<Funcionario> consultarFuncionarioPorNome(String nomeFuncionario) {
        ArrayList<Funcionario> tempFuncionarios = new ArrayList<>();
        CargoDao cargoDao = new CargoDao();
        UnidadeDAO unidadeDao = new UnidadeDAO();

        String sql = "SELECT * FROM FUNCIONARIOS WHERE NOME LIKE '" + nomeFuncionario + "%';";

        try {
            Funcionario funcionario = new Funcionario();
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                funcionario.setId(rs.getInt("ID"));
                funcionario.setCargo(cargoDao.pesquisarPorId(rs.getInt("CARGO_ID")));
                funcionario.setUnidade(unidadeDao.pesquisarPorId(rs.getInt("UNIDADE_ID")));
                funcionario.setNome(rs.getString("NOME"));

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
