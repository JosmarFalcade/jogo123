package model;

public class Guerreiro extends Pessoa {
    private String armamento;

    public Guerreiro() {
    }

    public Guerreiro(String nome, String cabelo, String olho, String pele, boolean sexo, String armamento) {
        super(nome, cabelo, olho, pele, sexo);
        this.armamento = armamento;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }

    @Override
    public String toString() {
        return "Guerreiro [armamento=" + armamento + ", getArmamento()=" + getArmamento() + ", getNome()=" + getNome()
                + ", getCabelo()=" + getCabelo() + ", getOlho()=" + getOlho() + ", getPele()=" + getPele()
                + ", isSexo()=" + isSexo() + ", getPontosDeVida()=" + getPontosDeVida() + "]";
    }

}
