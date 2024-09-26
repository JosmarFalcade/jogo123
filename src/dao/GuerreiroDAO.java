package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Guerreiro;

public class GuerreiroDAO {

    public void cadastrarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            // id, nome, olho, cabelo, pele, sexo, armamento, planoDeFuga, pontosDeVida
            String sql = "insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, ?, null, ?)";// reprodução da ordem baseada no banco de dados
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setBoolean(5, gVO.isSexo());
            pst.setString(6, gVO.getArmamento());
            pst.setInt(7, gVO.getPontosDeVida());
            pst.execute();// indice para o povoamento da tabela
            System.out.println("Guerreiro cadastrado com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Guerreiro.\n" + e.getMessage());
        }
    }

    public ArrayList<Guerreiro> getGuerreiros() {
        ArrayList<Guerreiro> guerreiros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is not null "
                    + "and planoDeFuga is null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet gs = pst.executeQuery();
            while (gs.next()) {
                Guerreiro guerreiro = new Guerreiro();
                guerreiro.setId(gs.getInt("id"));
                guerreiro.setNome(gs.getString("Nome"));
                guerreiro.setCabelo(gs.getString("Cabelo"));
                guerreiro.setOlho(gs.getString("Olho"));
                guerreiro.setPele(gs.getString("Pele"));
                guerreiro.setSexo(gs.getBoolean("Sexo"));
                guerreiro.setArmamento(gs.getString("armamento"));
                guerreiro.setPontosDeVida(gs.getInt("pontosDeVida"));
                guerreiros.add(guerreiro);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar o Guerreiro.\n"
                    + e.getMessage());
        }
        return guerreiros;
    }

    public Guerreiro getGuerreiroByNome(String nome) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where nome like ? and armamento is not null";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("Nome"));
                g.setCabelo(rs.getString("Cabelo"));
                g.setOlho(rs.getString("Olho"));
                g.setPele(rs.getString("Pele"));
                g.setSexo(rs.getBoolean("Sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Guerreiro.\n" + e.getMessage());
        }
        return g;
    }

    public void atualizarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?,"
                    + "olho = ?,"
                    + "cabelo = ?,"
                    + "pele = ?,"
                    + "armamento = ? "
                    + " where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setString(5, gVO.getArmamento());
            pst.setInt(6, gVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar guerreiro.\n" + e.getMessage());
        }
    }

    public boolean deletarGuerreiro(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ? and armamento is not null";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a Guerreiro.\n" + e.getMessage());
        }
        return true;
    }

    public Guerreiro getGuerreiroById(int id) throws SQLException{
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("Nome"));
                g.setCabelo(rs.getString("Cabelo"));
                g.setOlho(rs.getString("Olho"));
                g.setPele(rs.getString("Pele"));
                g.setSexo(rs.getBoolean("Sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Guerreiro.\n" + e.getMessage());
        }
        return g;
    }
}