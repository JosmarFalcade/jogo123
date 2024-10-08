package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Ladrao;

public class LadraoDAO {

    public void cadastrarLadrao(Ladrao lVO) {
        try {
            // id,nome,olho,cabelo,pele,sexo,armamento,planodefuga,pontosdevida//
            Connection con = Conexao.getConexao();
            String sql = "Insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, null,?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2, lVO.getOlho());
            pst.setString(3, lVO.getCabelo());
            pst.setString(4, lVO.getPele());
            pst.setBoolean(5, lVO.isSexo());
            pst.setString(6, lVO.getPlanoDeFuga());
            pst.setInt(7, lVO.getPontosDeVida());
            pst.execute();
            System.out.println("Ladrao cadastrado");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Ladrao. \n" + e.getMessage());

        }

    }

    public ArrayList<Ladrao> getLadrao() {
        ArrayList<Ladrao> ladrao = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where PlanoDeFuga is not null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Ladrao l = new Ladrao();
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setCabelo(rs.getString("cabelo"));
                l.setOlho(rs.getString("olho"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPlanoDeFuga(rs.getString("PlanoDeFuga"));
                l.setPontosDeVida(rs.getInt("pontosDeVida"));
                ladrao.add(l);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Ladrao. \n"
                    + e.getMessage());
        }
        return ladrao;
    }

    public Ladrao getLadraoByNome(String nome) {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                l.setNome(rs.getString("nome"));
                l.setCabelo(rs.getString("cabelo"));
                l.setOlho(rs.getString("olho"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPlanoDeFuga(rs.getString("armamento"));
                l.setPontosDeVida(rs.getInt("pontosDeVida"));
                l.setId(rs.getInt("id"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar ladrao. \n" + e.getMessage());

        }

        return l;

    }

    public void atualizarLadrao(Ladrao lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?,"
                    + "olho = ?,"
                    + "cabelo = ?,"
                    + "pele = ?,"
                    + "PlanoDeFuga = ? "
                    + " where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2, lVO.getOlho());
            pst.setString(3, lVO.getCabelo());
            pst.setString(4, lVO.getPele());
            pst.setString(5, lVO.getPlanoDeFuga());
            pst.setInt(6, lVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar ladrão. \n" + e.getMessage());
        }

    }

    public boolean deletarLadrao(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar ladrao.\n" + e.getMessage());
        }
        return true;
    }

    public Ladrao getLadraoById(int id) throws SQLException {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa " + "where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("Nome"));
                l.setCabelo(rs.getString("Cabelo"));
                l.setOlho(rs.getString("Olho"));
                l.setPele(rs.getString("Pele"));
                l.setSexo(rs.getBoolean("Sexo"));
                l.setPlanoDeFuga(rs.getString("planoDeFuga"));
                l.setPontosDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Ladrao.\n" + e.getMessage());
        }
        return l;
    }

}
