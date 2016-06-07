/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Funcionario;
import br.senac.tads.pi3.imeg.entity.RelatorioEstoque;
import br.senac.tads.pi3.imeg.entity.RelatorioFaturamento;
import br.senac.tads.pi3.imeg.entity.RelatorioVenda;
import br.senac.tads.pi3.imeg.entity.Unidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iosato
 */
public class RelatorioDao {

    private PreparedStatement pst;

    //PARA RELATORIOS VOLTADOS A VENDAS
    public ArrayList<RelatorioVenda> listarTresMaisVendidos() {
        String sql = "SELECT * FROM TRES_MAIS_VENDIDOS";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                ProdutoDao p = new ProdutoDao();
                r.setQtdeVendida(res.getInt("QTD_VENDA"));
                r.setProduto(p.pesquisarPorId(res.getInt("PRODUTO")));

                rVenda.add(r);
            }
            return rVenda;
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

    public List<RelatorioVenda> ultimosTresMeses(Date Hoje, Date tresMesesAtras) {
        String sql = "SELECT SAIDA.PRODUTOS_ID AS PRODUTOS, SUM(SAIDA.QTDE_PRODUTOS) AS VENDAS"
                + " FROM ITENS_SAIDA AS SAIDA"
                + " INNER JOIN PRODUTOS AS PROD ON SAIDA.PRODUTOS_ID = PROD.ID"
                + " WHERE SAIDA.DATA_TRANSACAO BETWEEN ? AND ? GROUP BY SAIDA.PRODUTOS_ID ORDER BY SAIDA.PRODUTOS_ID";
        try {
            pst = new Conexao().prepararStatement(sql);
            List<RelatorioVenda> relatorios = new ArrayList();
            pst.setDate(1, new java.sql.Date(tresMesesAtras.getTime()));
            pst.setDate(2, new java.sql.Date(Hoje.getTime()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                RelatorioVenda rv = new RelatorioVenda();
                rv.setProduto(new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS")));
                rv.setQtdeVendida(rs.getInt("VENDAS"));
                relatorios.add(rv);
            }
            return relatorios;
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

    public ArrayList<RelatorioVenda> listarMaisVendidosFilial(Funcionario funcionario) {
        String sql = "SELECT SUM(SAIDA.QTDE_PRODUTOS) AS \"QTD_VENDA\",\n"
                + "SAIDA.PRODUTOS_ID AS \"PRODUTO\" FROM ITENS_SAIDA SAIDA\n"
                + "WHERE ID IN ( CASE WHEN \n"
                + "(SELECT {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATA_TRANSACAO, CURRENT_DATE)}\n"
                + "FROM ITENS_SAIDA WHERE ID = SAIDA.ID  ) <= 7 THEN ID ELSE 0 END ) AND UNIDADES_ID = ?\n"
                + "GROUP BY SAIDA.PRODUTOS_ID \n"
                + "ORDER BY SUM(SAIDA.QTDE_PRODUTOS) DESC\n"
                + "OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                r.setQtdeVendida(res.getInt("QTD_VENDA"));
                r.setProduto(new ProdutoDao().pesquisarPorId(res.getInt("PRODUTO")));

                rVenda.add(r);
            }
            return rVenda;
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

    public ArrayList<RelatorioVenda> listarMaisVendidosVendedor(Funcionario funcionario) {
        String sql = "SELECT SUM(SAIDA.QTDE_PRODUTOS) AS \"QTD_VENDA\",\n"
                + "SAIDA.PRODUTOS_ID AS \"PRODUTO\" FROM ITENS_SAIDA SAIDA\n"
                + "WHERE id in ( CASE WHEN \n"
                + "(SELECT {fn TIMESTAMPDIFF(SQL_TSI_DAY, DATA_TRANSACAO, CURRENT_DATE)}\n"
                + "FROM ITENS_SAIDA WHERE ID = SAIDA.ID  ) <= 7 THEN ID ELSE 0 END ) AND UNIDADES_ID = ?\n"
                + " AND FUNCIONARIOS_ID = ?\n"
                + "GROUP BY SAIDA.PRODUTOS_ID \n"
                + "ORDER BY SUM(SAIDA.QTDE_PRODUTOS) DESC\n"
                + "OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY";
        try {
            ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, funcionario.getUnidade().getId());
            pst.setInt(2, funcionario.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                r.setQtdeVendida(res.getInt("QTD_VENDA"));
                r.setProduto(new ProdutoDao().pesquisarPorId(res.getInt("PRODUTO")));

                rVenda.add(r);
            }
            return rVenda;
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

    public ArrayList<RelatorioVenda> listarUnidadesQueMaisVenderam() {
        String sql = "SELECT * FROM UNIDADES_QUE_MAIS_VENDERAM";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                UnidadeDao uDao = new UnidadeDao();
                r.setUnidade(uDao.pesquisarPorId(res.getInt("UNIDADE")));
                r.setTotalValorVenda(res.getDouble("TOTAL_VENDAS"));

                rVenda.add(r);
            }
            return rVenda;
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

    //Falta Query
    public List<RelatorioVenda> listarFuncionariosQueMaisVenderamNosUltimosTresMeses(Date Hoje, Date tresMesesAtras) {
        String sql = "SELECT SAIDA.FUNCIONARIOS_ID AS FUNCIONARIO, SUM(QTDE_PRODUTOS*SAIDA.PRECO_VENDA) AS TOTAL FROM ITENS_SAIDA SAIDA WHERE SAIDA.DATA_TRANSACAO BETWEEN ? AND ?  GROUP BY SAIDA.FUNCIONARIOS_ID ORDER BY SUM(QTDE_PRODUTOS*SAIDA.PRECO_VENDA) DESC";
        try {
            List<RelatorioVenda> rVenda = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            pst.setDate(1, new java.sql.Date(tresMesesAtras.getTime()));
            pst.setDate(2, new java.sql.Date(Hoje.getTime()));
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                r.setFuncionario(new FuncionarioDao().pesquisarPorId(res.getInt("FUNCIONARIO")));
                r.setQtdeVendida(res.getInt("TOTAL"));
                rVenda.add(r);
            }
            return rVenda;
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

    // Falta Query 
    public ArrayList<RelatorioVenda> listarFuncionariosQueMaisVenderamNaUnidade(Unidade unidade) {
        String sql = "SELECT  SAIDA.FUNCIONARIOS_ID AS \"FUNCIONARIO\", "
                + "SUM(QTDE_PRODUTOS*SAIDA.PRECO_VENDA) AS \"TOTAL_VENDAS\" "
                + "FROM ITENS_SAIDA SAIDA WHERE id in ( case when ("
                + "select {fn TIMESTAMPDIFF(SQL_TSI_DAY, data_transacao, current_date)} "
                + "from ITENS_SAIDA where id = SAIDA.id  ) <=7 then id else 0 end ) "
                + "AND SAIDA.UNIDADES_ID = ? "
                + "GROUP BY SAIDA.FUNCIONARIOS_ID "
                + "ORDER BY SUM(SAIDA.QTDE_PRODUTOS*SAIDA.PRECO_VENDA) DESC";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, unidade.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                FuncionarioDao fDao = new FuncionarioDao();
                r.setTotalValorVenda(res.getDouble("TOTAL_VENDAS"));
                r.setFuncionario(fDao.pesquisarPorId(res.getInt("FUNCIONARIO")));

                rVenda.add(r);
            }
            return rVenda;
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

    //PARA RELATÓRIOS VOLTADOS A ESTOQUE
    public ArrayList<RelatorioEstoque> listarProdutosComBaixoEstoque() {
        String sql = "SELECT * FROM BAIXO_ESTOQUE";
        ArrayList<RelatorioEstoque> rEstoque = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioEstoque e = new RelatorioEstoque();
                ProdutoDao pDao = new ProdutoDao();
                e.setQuantidade(res.getInt("QTD_PRODUTOS"));
                e.setProduto(pDao.pesquisarPorId(res.getInt("ID")));
                rEstoque.add(e);
            }
            return rEstoque;
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

    public ArrayList<RelatorioEstoque> listarProdutosComAltoEstoque() {
        String sql = "SELECT * FROM ALTO_ESTOQUE";
        ArrayList<RelatorioEstoque> rEstoque = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioEstoque e = new RelatorioEstoque();
                ProdutoDao pDao = new ProdutoDao();
                e.setQuantidade(res.getInt("QTD_PRODUTOS"));
                e.setProduto(pDao.pesquisarPorId(res.getInt("ID")));

                rEstoque.add(e);
            }
            return rEstoque;
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

    //PARA RELATORIOS VOLTADOS A FATURAMENTO    
    public ArrayList<RelatorioFaturamento> faturamentoUltimosSeteDias() {
        String sql = "SELECT * FROM FATURAMENTO_SEMANA";
        ArrayList<RelatorioFaturamento> rFaturamento = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioFaturamento f = new RelatorioFaturamento();
                f.setFaturamento(res.getDouble("FATURAMENTO_SEMANA"));

                rFaturamento.add(f);
            }
            return rFaturamento;
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

    public ArrayList<RelatorioFaturamento> faturamentoUltimosSeteDiasUnidade(Unidade unidade) {
        String sql = "select SUM(QTDE_PRODUTOS*SAIDA.PRECO_VENDA) AS \"FATURAMENTO_SEMANA\" "
                + "from ITENS_SAIDA SAIDA "
                + "where id in ( "
                + "case when (select {fn TIMESTAMPDIFF(SQL_TSI_DAY, data_transacao, current_date)}"
                + "from ITENS_SAIDA where id = SAIDA.id  ) <=7 then id else 0 end )"
                + "and UNIDADES_ID = ? OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;";
        ArrayList<RelatorioFaturamento> rFaturamento = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, unidade.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioFaturamento f = new RelatorioFaturamento();
                f.setFaturamento(res.getDouble("FATURAMENTO_SEMANA"));

                rFaturamento.add(f);
            }
            return rFaturamento;
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
