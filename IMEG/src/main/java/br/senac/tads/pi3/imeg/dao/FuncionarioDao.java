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
    public boolean adicionar(Funcionario funcionario) {

        String sql = "INSERT INTO FUNCIONARIOS "
                + "(CARGOS_ID, UNIDADES_ID, ACESSOS_ID, NOME, EMAIL, SALT, SENHA_HASH, STATUS)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getCargo().getId());
            pst.setInt(2, funcionario.getUnidade().getId());
            pst.setInt(3, funcionario.getAcesso().getId());
            pst.setString(4, funcionario.getNome());
            pst.setString(5, funcionario.getEmail());
            pst.setString(6, funcionario.getSalt());
            pst.setString(7, String.copyValueOf(funcionario.getSenhaHash()));
            pst.setBoolean(8, funcionario.isStatus());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    //Altera informações de um funcionário
    public boolean alterar(Funcionario funcionario) {
        String sql = "UPDATE FUNCIONARIOS SET CARGOS_ID = ?, UNIDADES_ID = ?, "
                + "ACESSOS_ID = ?, NOME = ?, EMAIL = ?, STATUS = ? "
                + "WHERE ID = ?";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getCargo().getId());
            pst.setInt(2, funcionario.getUnidade().getId());
            pst.setInt(3, funcionario.getAcesso().getId());
            pst.setString(4, funcionario.getNome());
            pst.setString(5, funcionario.getEmail());
            pst.setBoolean(6, funcionario.isStatus());
            pst.setInt(7, funcionario.getId());

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
    public ArrayList<Funcionario> pesquisarPorNome(String nome) {
        ArrayList<Funcionario> tempFuncionarios = new ArrayList<>();
        CargoDao cargoDao = new CargoDao();
        UnidadeDao unidadeDao = new UnidadeDao();

        String sql = "SELECT FUNCIONARIOS.* FROM FUNCIONARIOS WHERE NOME LIKE '%?%';";

        try {
            Funcionario funcionario = new Funcionario();
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                funcionario.setId(rs.getInt("ID"));
                funcionario.setCargo(cargoDao.pesquisarPorId(rs.getInt("CARGOS_ID")));
                funcionario.setUnidade(unidadeDao.pesquisarPorId(rs.getInt("UNIDADES_ID")));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setEmail(rs.getString("EMAIL"));
                funcionario.setSalt(rs.getString("SALT"));
                funcionario.setSenhaHash(rs.getString("SENHA_HASH").toCharArray());
                funcionario.setStatus(rs.getBoolean("STATUS"));
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
    public Funcionario pesquisarPorId(int id) {
        CargoDao cargoDao = new CargoDao();
        UnidadeDao unidadeDao = new UnidadeDao();
        AcessoDao acessoDao = new AcessoDao();

        String sql = "SELECT * FROM FUNCIONARIOS WHERE ID = ?";

        try {
            Funcionario funcionario = new Funcionario();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                funcionario.setId(rs.getInt("ID"));
                funcionario.setCargo(cargoDao.pesquisarPorId(rs.getInt("CARGOS_ID")));
                funcionario.setAcesso(acessoDao.pesquisarPorId(rs.getInt("ACESSOS_ID")));
                funcionario.setUnidade(unidadeDao.pesquisarPorId(rs.getInt("UNIDADES_ID")));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setEmail(rs.getString("EMAIL"));
                funcionario.setSalt(rs.getString("SALT"));
                funcionario.setSenhaHash(rs.getString("SENHA_HASH").toCharArray());
                funcionario.setStatus(rs.getBoolean("STATUS"));

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
        String sql = "SELECT ID, CARGOS_ID, ACESSOS_ID, UNIDADES_ID, NOME, EMAIL, STATUS FROM FUNCIONARIOS ORDER BY NOME ASC";
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
                f.setAcesso(new AcessoDao().pesquisarPorId(res.getInt("ACESSOS_ID")));
                f.setNome(res.getString("NOME"));
                f.setEmail(res.getString("EMAIL"));
                f.setStatus(res.getBoolean("STATUS"));

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

    public Funcionario pesquisarPorEmail(String email) {
        String sql = "SELECT FUNCIONARIOS.* FROM FUNCIONARIOS WHERE EMAIL=? AND STATUS=true";
        try {
            Funcionario funcionario = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, email);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                funcionario = new Funcionario();
                funcionario.setId(res.getInt("ID"));
                funcionario.setNome(res.getString("NOME"));
                funcionario.setEmail(res.getString("EMAIL"));
                funcionario.setStatus(res.getBoolean("STATUS"));
                funcionario.setAcesso(new AcessoDao().pesquisarPorId(res.getInt("ACESSOS_ID")));
                funcionario.setCargo(new CargoDao().pesquisarPorId(res.getInt("CARGOS_ID")));
                funcionario.setUnidade(new UnidadeDao().pesquisarPorId(res.getInt("UNIDADES_ID")));
                funcionario.setSenhaHash(res.getString("SENHA_HASH").toCharArray());
                funcionario.setSalt(res.getString("SALT"));
            }
            return funcionario;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    public boolean autenticar(String nome) {
        String sql = "SELECT FUNCIONARIOS.* FROM FUNCIONARIOS WHERE NOME=?";
        return false;
    }

    public boolean alterarMeusDados(Funcionario funcionario) {
        String sql = "UPDATE FUNCIONARIOS SET NOME=?" + (funcionario.getSenha() != null ? ", SALT=?, SENHA_HASH=? " : "") + " WHERE ID=?";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, funcionario.getNome());
            if (funcionario.getSenha() != null) {
                pst.setString(2, funcionario.getSalt());
                pst.setString(3, String.copyValueOf(funcionario.getSenhaHash()));
                pst.setInt(4, funcionario.getId());
            } else {
                pst.setInt(2, funcionario.getId());
            }
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    public Boolean estaEmMatriz(int idUnidade) {
        String sql = "SELECT * FROM FUNCIONARIOS WHERE ACESSOS_ID = 1 AND UNIDADES_ID = ? AND STATUS = TRUE";
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, idUnidade);
            ResultSet res = pst.executeQuery();
           
            if (!res.next()) {
                return false;
            }
            
            return true;

        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }
}
