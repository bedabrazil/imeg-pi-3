/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;


import br.senac.tads.pi3.imeg.entity.HistoricoEntrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author diogo.lsousa
 */
public class HistoricoEntradaDao {
    
    
        public void incluirHistoricoEntrada(HistoricoEntrada historicoEntrada) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO HISTORICOENTRADA(PRODUTOS_ID, FUNCIONARIOS_ID, DATA_TRANSACAO, QTDE_PRODUTOS) VALUES(?,?,?,?)";

        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, historicoEntrada.getProdutos_id());
            stmt.setInt(2, historicoEntrada.getFuncionarios_id());
            stmt.setDate(3, historicoEntrada.getData_transacao().getTime());
            stmt.setInt(4, historicoEntrada.getQtde_produtos();
            
                stmt.execute();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(HistoricoEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    public void consultarHistoricoEntrada(HistoricoEntrada historicoEntrada){
    
    }
    
    public void alterarHistoricoEntrada(HistoricoEntrada historicoEntrada){
    
    }
    
    public void removerHistoricoEntrada(HistoricoEntrada historicoEntrada){
    
    }
}
