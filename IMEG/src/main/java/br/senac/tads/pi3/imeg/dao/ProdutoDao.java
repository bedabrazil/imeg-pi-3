/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.senac.tads.pi3.imeg.entity.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matheus.ssouza1
 */
public class ProdutoDao {

    private PreparedStatement pst;

    public boolean adicionar(Produto produto) {

        String sql = "INSERT INTO PRODUTOS(CATEGORIAS_ID, NOME, QTDE_MIN, QTDE_MAX, PRECO_VENDA, PRECO_CUSTO, STATUS, DESCRICAO, DESCRICAO_CURTA)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCategoria().getId());
            pst.setString(2, produto.getNome());
            pst.setInt(3, produto.getQtdeMin());
            pst.setInt(4, produto.getQtdeMax());
            pst.setDouble(5, produto.getPrecoVenda());
            pst.setDouble(6, produto.getPrecoCusto());
            pst.setBoolean(7, produto.isStatus());
            pst.setString(8, produto.getDescricao());
            pst.setString(9, produto.getDescricaoCurta());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<Produto> consultarProduto(String pesquisa, Categoria categoria) {
        String sql = "SELECT * FROM PRODUTOS WHERE CATEGORIAS_ID = ? AND NOME LIKE '% ? %'";
        ArrayList<Produto> tempProduto = new ArrayList<>();

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, categoria.getId());
            pst.setString(2, pesquisa);
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                Produto produto = new Produto();
                CategoriaDao cDao = new CategoriaDao();

                produto.setNome(rs.getString("NOME"));
                produto.setCategoria(cDao.pesquisarPorId(rs.getInt("CATEGORIAS_ID")));
                produto.setPrecoCusto(rs.getDouble("PRECO_CUSTO"));
                produto.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                produto.setQtdeMin(rs.getInt("QTDE_MIN"));
                produto.setQtdeMax(rs.getInt("QTDE_MAX"));
                produto.setSaldo(rs.getInt("SALDO"));
                produto.setStatus(rs.getBoolean("STATUS"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setDescricaoCurta(rs.getString("DESCRICAO_CURTA"));
                tempProduto.add(produto);

            }
            return tempProduto;

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

    public Produto pesquisarPorId(int id) {
        String sql = "SELECT PRODUTOS.* FROM PRODUTOS WHERE ID=?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setCategoria(new CategoriaDao().pesquisarPorId(rs.getInt("CATEGORIAS_ID")));
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setQtdeMin(rs.getInt("QTDE_MIN"));
                produto.setQtdeMax(rs.getInt("QTDE_MAX"));
                produto.setSaldo(rs.getInt("SALDO"));
                produto.setStatus(rs.getBoolean("STATUS"));
                produto.setPrecoCusto(rs.getDouble("PRECO_CUSTO"));
                produto.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setDescricaoCurta(rs.getString("DESCRICAO_CURTA"));
                return produto;
            }

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

    public Produto pesquisarPorIdItensEntrada(int id) {
        String sql = "SELECT IE.PRODUTOS_ID, PRECO_VENDA FROM ITENS_ENTRADA AS IE WHERE PRODUTOS_ID=?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Produto produto = new ProdutoDao().pesquisarPorId(rs.getInt("PRODUTOS_ID"));
                produto.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                return produto;
            }

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

    public boolean alterar(Produto produto) {
        String sql = "UPDATE PRODUTOS SET CATEGORIAS_ID=?, NOME=?, QTDE_MIN=?, QTDE_MAX=?, STATUS=?, PRECO_CUSTO=?, PRECO_VENDA=?, DESCRICAO=?, DESCRICAO_CURTA=?"
                + "WHERE ID=?";
        // UPDATE

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getCategoria().getId());
            pst.setString(2, produto.getNome());
            pst.setInt(3, produto.getQtdeMin());
            pst.setInt(4, produto.getQtdeMax());
            pst.setBoolean(5, produto.isStatus());
            pst.setDouble(6, produto.getPrecoCusto());
            pst.setDouble(7, produto.getPrecoVenda());
            pst.setString(8, produto.getDescricao());
            pst.setString(9, produto.getDescricaoCurta());
            pst.setInt(10, produto.getId());

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

    public ArrayList<Produto> listarMatriz() {
        String sql = "SELECT PRODUTOS.* FROM PRODUTOS ORDER BY ID DESC";
        try {
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            ArrayList<Produto> produtos = new ArrayList<>();
            while (res.next()) {
                Produto p = new Produto();
                p.setId(res.getInt("ID"));
                p.setNome(res.getString("NOME"));
                p.setQtdeMin(res.getInt("QTDE_MIN"));
                p.setQtdeMax(res.getInt("QTDE_MAX"));
                p.setSaldo(res.getInt("SALDO"));
                p.setPrecoCusto(res.getDouble("PRECO_CUSTO"));
                p.setPrecoVenda(res.getDouble("PRECO_VENDA"));
                p.setStatus(res.getBoolean("STATUS"));
                p.setDescricaoCurta(res.getString("DESCRICAO_CURTA"));
                produtos.add(p);
            }
            return produtos;
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean pesquisarPorNome(String nome) {
        String sql = "SELECT NOME FROM PRODUTOS WHERE NOME=?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
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

    public ArrayList<Produto> produtosComSaldo() {
        String sql = "SELECT  P.* \n"
                + "FROM PRODUTOS as P\n"
                + "WHERE P.ID IN (SELECT IE.PRODUTOS_ID FROM ITENS_ENTRADA AS IE WHERE IE.PRODUTOS_ID=P.ID)\n"
                + "AND P.SALDO > 0 AND P.STATUS = TRUE";
        try {
            ArrayList<Produto> produtos = new ArrayList<>();
            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Produto produto = new Produto();
                produto.setCategoria(new CategoriaDao().pesquisarPorId(res.getInt("CATEGORIAS_ID")));
                produto.setId(res.getInt("ID"));
                produto.setNome("NOME");
                produto.setPrecoVenda(res.getDouble("PRECO_VENDA"));
                produto.setDescricaoCurta(res.getString("DESCRICAO_CURTA"));
                produto.setDescricao(res.getString("DESCRICAO"));
                produto.setSaldo(res.getInt("SALDO"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    public void atualizarSaldo(Produto produto, int qtd) {

        String sql = "UPDATE PRODUTOS SET SALDO=? WHERE ID=?";
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, produto.getSaldo() - qtd);
            pst.setInt(2, produto.getId());
            pst.execute();
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<Produto> pesquisarProdutos(String search) {
        String sql = "SELECT ID FROM PRODUTOS WHERE NOME LIKE '%" + search + "%' AND SALDO > 0";
        try {
            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto p = this.pesquisarPorId(rs.getInt("ID"));
                produtos.add(p);
            }

            return produtos;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
}
