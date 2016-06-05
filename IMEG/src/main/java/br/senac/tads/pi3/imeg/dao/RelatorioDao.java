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

    public ArrayList<RelatorioVenda> listarMaisVendidosFilial(Funcionario funcionario) {
        String sql = "SELECT SUM(SAIDA.QTDE_PRODUTOS) AS \"QTD_VENDA\",\n"
                + "SAIDA.PRODUTOS_ID AS \"PRODUTO\" FROM ITENS_SAIDA SAIDA\n"
                + "WHERE id in ( CASE WHEN \n"
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
        String sql = "SELECT * FROM VENDA_UNIDADE";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                UnidadeDao uDao = new UnidadeDao();
                r.setUnidade(uDao.pesquisarPorId(res.getInt("UNIDADE")));
                r.setQtdeVendida(res.getInt("VL_VENDA"));

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
    
    public ArrayList<RelatorioVenda> listarFuncionariosQueMaisVenderamGeral() {
        String sql = "SELECT * FROM VENDA_FUNCIONARIOS";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                FuncionarioDao fDao = new FuncionarioDao();
                r.setFuncionario(fDao.pesquisarPorId(res.getInt("FUNCIONARIO")));
                r.setQtdeVendida(res.getInt("VL_VENDA"));

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
       
       
    public ArrayList<RelatorioVenda> listarFuncionariosQueMaisVenderamNaUnidade(Unidade unidade) {
        String sql = "SELECT * FROM VENDAS_FUNCIONARIOS_UNIDADE";
        ArrayList<RelatorioVenda> rVenda = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, unidade.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioVenda r = new RelatorioVenda();
                ProdutoDao pDao = new ProdutoDao();
                r.setQtdeVendida(res.getInt("QTD_VENDA"));
                r.setProduto(pDao.pesquisarPorId(res.getInt("PRODUTO")));

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
                e.setProduto(pDao.pesquisarPorId(res.getInt("PRODUTO")));

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
                e.setProduto(pDao.pesquisarPorId(res.getInt("PRODUTO")));

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
        String sql = "SELECT * FROM FATURAMENTO_SETE_DIAS";
        ArrayList<RelatorioFaturamento> rFaturamento = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioFaturamento f = new RelatorioFaturamento();
                f.setFaturamento(res.getDouble("FATURAMENTO"));

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
        String sql = "SELECT * FROM FATURAMENTO_SETE_DIAS_UNIDADE";
        ArrayList<RelatorioFaturamento> rFaturamento = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, unidade.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                RelatorioFaturamento f = new RelatorioFaturamento();
                f.setFaturamento(res.getDouble("FATURAMENTO"));

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
