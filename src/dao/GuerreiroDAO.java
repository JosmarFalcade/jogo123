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
            // id,nome,olho,cabelo,pele,sexo,armamento,planodefuga,pontosdevida//
            Connection con = Conexao.getConexao();
            String sql = "Insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, ?, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setBoolean(5, gVO.isSexo());
            pst.setString(6, gVO.getArmamento());
            pst.setInt(7, gVO.getPontosDeVida());
            pst.execute();
            System.out.println("Guerreiro cadastrado");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Guerreiro. \n" + e.getMessage());

        }

    }

    public ArrayList<Guerreiro> getGuerreiro() {
        ArrayList<Guerreiro> guerreiro = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is not null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Guerreiro g = new Guerreiro();
                g.setNome(rs.getString("nome"));
                g.setCabelo(rs.getString("cabelo"));
                g.setOlho(rs.getString("olho"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
                guerreiro.add(g);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Guerreiro. \n"
                    + e.getMessage());
        }
        return guerreiro;
    }

    public Guerreiro getGuerreiroByNome(String nome) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                g.setNome(rs.getString("nome"));
                g.setCabelo(rs.getString("cabelo"));
                g.setOlho(rs.getString("olho"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontosDeVida(rs.getInt("pontosDeVida"));
                g.setId(rs.getInt("id"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar guerreiro. \n" + e.getMessage());

        }

        return g;

    }

    public void atualizarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set cabelo = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getCabelo());
            pst.setInt(2, gVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar vítima. \n" + e.getMessage());
        }

    }

    public boolean deletarGuerreiro(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar guerreiro.\n" + e.getMessage());
        }
        return true;
    }

}


