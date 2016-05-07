/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.HistoricoSaida;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author diogo.lsousa
 */
public class HistoricoSaidaDao {
    private PreparedStatement pst;
    public void incluirHistoricoSaida(HistoricoSaida historicoSaida) {


         String sql = "INSERT INTO HISTORICOENTRADA(PRODUTOS_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS) VALUES(?,?,?,?)";


        try {
            pst = new Conexao().prepararStatement(sql);
//            pst.setInt(1, historicoSaida.getProduto());
//            pst.setInt(2, historicoSaida.getFuncionarios_id());
            pst.setDate(3, new Date(System.currentTimeMillis()));
            pst.setInt(4, historicoSaida.getQtde_produtos());
            
            pst.execute();
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
