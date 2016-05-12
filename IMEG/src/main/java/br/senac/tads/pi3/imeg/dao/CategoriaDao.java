/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.imeg.dao;

import br.senac.tads.pi3.imeg.entity.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogo.lsousa
 */
public class CategoriaDao {

    private PreparedStatement pst;

    public boolean incluirCategoria(Categoria categoria) {

        String sql = "INSERT INTO CATEGORIAS(NOME, STATUS) VALUES(?,?)";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.setBoolean(2, categoria.isStatus());

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

    public Categoria editarCategoria(int id) {
        String sql = "SELECT CATEGORIAS.* FROM CATEGORIAS WHERE ID=?";
        try {
            Categoria categoria = null;
            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                categoria = new Categoria();
                categoria.setId(res.getInt("ID"));
                categoria.setNome(res.getString("NOME"));
                categoria.setStatus(res.getBoolean("STATUS"));
            }
            return categoria;
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public ArrayList<Categoria> consultarCategoria(Categoria categoria) {

        String sql = "SELECT * FROM CATEGORIAS WHERE NOME LIKE '%" + categoria.getNome() + "%';";
        ArrayList<Categoria> listaCategoria = new ArrayList<>();

        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                categoria.setNome(rs.getString("NOME"));
                categoria.setStatus(rs.getBoolean("STATUS"));

                listaCategoria.add(categoria);
            }
            return listaCategoria;

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();

            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public boolean alterarCategoria(Categoria categoria) {
        String sql = "UPDAtE CATEGORIAS SET NOME=?, STATUS=? WHERE ID =?";

        try {
            pst = new Conexao().prepararStatement(sql);
            pst.setString(1, categoria.getNome());
            pst.setBoolean(2, categoria.isStatus());
            pst.setInt(3, categoria.getId());
            if (pst.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO DE SQL: " + ex.getMessage());
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
            }
        }
        return false;
    }

    public void removerCategoria(Categoria categoria) {

    }

    public ArrayList<Categoria> listar() {
        String sql = "SELECT CATEGORIAS.* FROM CATEGORIAS ORDER BY ID DESC";
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {

            pst = new Conexao().prepararStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Categoria c = new Categoria();
                c.setId(res.getInt("ID"));
                c.setNome(res.getString("NOME"));
                c.setStatus(res.getBoolean("STATUS"));
                categorias.add(c);
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage() + "\n" + e.getSQLState());
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return categorias;
    }

    public Categoria pesquisarPorId(int id) {
        String sql = "SELECT CATEGORIAS.* FROM CATEGORIAS where ID=?";
        try {

            pst = new Conexao().prepararStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            Categoria categoria = new Categoria();
            if (res.next()) {

                categoria.setId(res.getInt("ID"));
                categoria.setNome(res.getString("NOME"));
                categoria.setStatus(res.getBoolean("STATUS"));
            }
            return categoria;
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
