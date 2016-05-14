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
    public boolean incluirFuncionario(Funcionario funcionario) {

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
        return true;
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
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    //Lista funcionarios com um nome passado por parâmetro
    public ArrayList<Funcionario> consultarFuncionarioPorNome(String nomeFuncionario) {
        ArrayList<Funcionario> tempFuncionarios = new ArrayList<>();
        CargoDao cargoDao = new CargoDao();
        UnidadeDao unidadeDao = new UnidadeDao();

        String sql = "SELECT * FROM FUNCIONARIOS WHERE NOME LIKE '" + nomeFuncionario + "%'";

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
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //Consulta funcionario por id
    public Funcionario consultarFuncionarioPorId(int id) {
        CargoDao cargoDao = new CargoDao();
        UnidadeDao unidadeDao = new UnidadeDao();

        String sql = "SELECT ID, CARGO_ID, UNIDADE_ID, NOME FROM FUNCIONARIOS WHERE ID = '" + id + "%'";

        try {
            Funcionario funcionario = new Funcionario();
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                funcionario.setId(rs.getInt("ID"));
                funcionario.setCargo(cargoDao.pesquisarPorId(rs.getInt("CARGO_ID")));
                funcionario.setUnidade(unidadeDao.pesquisarPorId(rs.getInt("UNIDADE_ID")));
                funcionario.setNome(rs.getString("NOME"));

            }
            return funcionario;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //Lista Funcionarios
    public ArrayList<Funcionario> listar() {
        String sql = "SELECT ID, CARGOS_ID, UNIDADES_ID, NOME, EMAIL FROM FUNCIONARIOS ORDER BY ID DESC";
        ArrayList<Funcionario> funcionario = new ArrayList<>();
        CargoDao cargoDao = new CargoDao();
        UnidadeDao unidadeDao = new UnidadeDao();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Funcionario f = new Funcionario();
                f.setId(res.getInt("ID"));
                f.setCargo(cargoDao.pesquisarPorId(res.getInt("CARGOS_ID")));
                f.setUnidade(unidadeDao.pesquisarPorId(res.getInt("UNIDADES_ID")));
                f.setNome(res.getString("NOME"));
                f.setNome(res.getString("EMAIL"));
                funcionario.add(f);
            }
            return funcionario;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

}
