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
            Connection con = Conexao.getConexao();
            String sql = "insert into pessoa values" + "(null, ?, ?, ?, ?, ?, null, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setBoolean(5, vVO.isSexo());
            pst.setInt(6, vVO.getPontosDeVida());
            pst.execute();
            System.out.println("Vitima cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pessoa.\n" + e.getMessage());
        }
    }

    public ArrayList<Pessoa> getVitimas() {
        ArrayList<Pessoa> vitimas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is null"
                    + "and planoDeFuga is null";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println("Erro ao listar Vitima.\n" + e.getMessage());
        }
        return vitimas;
    }

}
