/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eilane
 */
public class FuncionarioDao {

    public void incluirFuncionario(Funcionario funcionario) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO FUNCIONARIOS "
                + "(CARGOS_ID, UNIDADES_ID, NOME)"
                + "VALUES (?, ?, ?)";
        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdcargo());
            stmt.setInt(2, funcionario.getIdunidade());
            stmt.setString(3, funcionario.getNome());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
