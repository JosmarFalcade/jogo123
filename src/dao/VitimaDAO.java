package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Pessoa;

public class VitimaDAO {

    public void cadastrarVitima(Pessoa vVO) {
        try {
            // id,nome,olho,cabelo,pele,sexo,armamento,planodefuga,pontosdevida//
            Connection con = Conexao.getConexao();
            String sql = "Insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, null, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setBoolean(5, vVO.isSexo());

            pst.setInt(6, vVO.getPontosDeVida());
            pst.execute();
            System.out.println("Vítima cadastrada");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Pessoa. \n" + e.getMessage());

        }

    }

    public ArrayList<Pessoa> getVitimas() {
        ArrayList<Pessoa> vitimas = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is null "
                    + "and planoDeFuga is null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pessoa v = new Pessoa();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontosDeVida(rs.getInt("pontosDeVida"));
                vitimas.add(v);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Vítima. \n"
                    + e.getMessage());
        }
        return vitimas;
    }

    public Pessoa getVitimaByNome(String nome) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontosDeVida(rs.getInt("pontosDeVida"));
                v.setId(rs.getInt("id"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar vítima. \n" + e.getMessage());

        }

        return v;

    }

    public Pessoa getVitimaById(int id) throws SQLException {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontosDeVida(rs.getInt("pontosDeVida"));
                v.setId(rs.getInt("id"));

            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar vítima. \n" + e.getMessage());

        }

        return v;
    }

    public void atualizarVitima(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, olho = ?, pele = ?, cabelo = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getPele());
            pst.setString(4, vVO.getCabelo());
            pst.setInt(5, vVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar vítima. \n" + e.getMessage());
        }

    }

    public boolean deletarVitima(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar vitima.\n" + e.getMessage());
        }
        return true;
    }

}
