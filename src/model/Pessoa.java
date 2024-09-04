package model;

public class Pessoa {
    private String nome;
    private String cabelo;
    private String olho;
    private String pele;
    private boolean sexo;
    private int pontosDeVida = 100;

    public Pessoa() {
    }

    public Pessoa(String nome, String cabelo, String olho, String pele, boolean sexo) {
        this.nome = nome;
        this.cabelo = cabelo;
        this.olho = olho;
        this.pele = pele;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getOlho() {
        return olho;
    }

    public void setOlho(String olho) {
        this.olho = olho;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cabelo=" + cabelo + ", olho=" + olho + ", pele=" + pele + ", sexo=" + sexo
                + ", pontosDeVida=" + pontosDeVida + "]";
    }

    public void dano(int dano) {
        this.pontosDeVida = this.pontosDeVida - dano;
    }

    public boolean gameOver() {
        if (this.pontosDeVida <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
