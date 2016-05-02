/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoSaida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author diogo.lsousa
 */
public class HistoricoSaidaDao {

    public void incluirHistoricoSaida(HistoricoSaida historicoSaida) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        Connection conn = null;

         String sql = "INSERT INTO HISTORICOENTRADA(PRODUTOS_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS) VALUES(?,?,?,?)";


        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, historicoSaida.getProdutos_id());
            stmt.setInt(2, historicoSaida.getFuncionarios_id());
            stmt.setDate(3, historicoSaida.getData_transacao().getTime());
            stmt.setInt(4, historicoSaida.getQtde_produtos();
            
            stmt.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HistoricoSaidaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarHistoricoSaida(HistoricoSaida historicoSaida) {

    }

    public void alterarHistoricoSaida(HistoricoSaida historicoSaida) {

    }

    public void removerHistoricoSaida(HistoricoSaida historicoSaida) {

    }
}
