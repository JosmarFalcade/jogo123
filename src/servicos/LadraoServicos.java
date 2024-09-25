package servicos;


import java.util.ArrayList;

import dao.DAOFactory;
import dao.LadraoDAO;
import model.Ladrao;

public class LadraoServicos {
    LadraoDAO lDAO = DAOFactory.getLadraoDAO();

    public void cadastrarLadrao(Ladrao lVO) {
        lDAO.cadastrarLadrao(lVO);
    }

    public ArrayList<Ladrao> listaLadrao() {
        return lDAO.getLadrao();
    }

    public Ladrao buscaLadraoByNome(String nome) {
        return lDAO.getLadraoByNome(nome);
    }
    
     public Ladrao getLadraoById(int id) {
        return lDAO.getLadraoById(id);
    }

    public void atualizarLadrao(Ladrao lVO) {
        lDAO.atualizarLadrao(lVO);
    }

    public boolean deletarLadrao(int id) {
        return lDAO.deletarLadrao(id);
    }

}
