/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
