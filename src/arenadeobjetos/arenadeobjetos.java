package arenadeobjetos;

import java.util.ArrayList;
import java.util.Scanner;

import model.Guerreiro;
import model.Ladrao;
import model.Pessoa;

public class arenadeobjetos {
    static Scanner ler = new Scanner(System.in);
    static int opMP;
    static ArrayList<Guerreiro> guerreiros = new ArrayList<>();
    static ArrayList<Ladrao> ladrões = new ArrayList<>();
    static ArrayList<Pessoa> vitimas = new ArrayList<>();

    public static int lerInt() {
        Scanner ler = new Scanner(System.in);
        int num = 99;
        try {
            num = ler.nextInt();
        } catch (Exception e) {
            System.out.print("Tente novamente: ");
            lerInt();
        }
        return num;
    }

    public static void main(String[] args) {
        /*
         * Pessoa vitima = new Pessoa("Vitima 1", "Castanho", "Castanho Claro",
         * "Branca", true);
         * System.out.println("Vitima:\n" + vitima.toString());
         * System.out.println("Perdeu 25 pontos de vida");
         * int pvAtual = vitima.getPontosDeVida();
         * vitima.setPontosDeVida(pvAtual - 25);
         * System.out.println("Vitima:\n" + vitima.toString());
         * System.out.println("Perdeu 30 pontos de vida");
         * vitima.dano(30);
         * System.out.println("Vitima:\n" + vitima.toString());
         * Guerreiro denis = new Guerreiro("Denis", "Cinza", "Verde", "Branca", false,
         * "Espada Longa");
         * System.out.println("Guerreiro:\n" + denis.toString());
         */
        /*
         * String texto;
         * int num;
         * System.out.print("Digite seu nome: ");
         * texto = ler.nextLine();
         * System.out.print("Digite sua idade:");
         * num = lerInt();
         */
        System.out.println(".:Arena de Objetos:.");
        do {
            menuP();
            subMenuP(opMP);
        } while (opMP != 0);

    }

    public static void menuP() {
        String menu;
        menu = "1 - Criar Personagens"
                + "\n2 - Listar Personagens"
                + "\n3 - Batalha"
                + "\n0 - Sair do Jogo"
                + "\nDigite a opção: ";
        System.out.print(menu);
        opMP = lerInt();

    }

    public static void subMenuP(int omP) {
        System.out.println("::SubMenu::");
        String subMenu = null;
        switch (omP) {
            case 1:
                System.out.println("1 - Guerreiro"
                        + "\n2 - Ladrão"
                        + "\n3 - Vitima"
                        + "\nDigite a opção:");
                int opSM = lerInt();
                criarPersona(opSM);
                break;
            case 2:
                System.out.println("Lista de personagens");
                System.out.println(guerreiros.toString());
                System.out.println(ladrões.toString());
                System.out.println("Lista bonita");
                for (Guerreiro g : guerreiros) {
                    System.out.println("Guerreiro: " + g.getNome());
                    System.out.println("\tArmamento: " + g.getArmamento());
                    System.out.println("\tPontos de vida: " + g.getPontosDeVida());
                }
                for (Ladrao ladrao : ladrões) {
                    System.out.println("Ladrão: " + ladrao.getNome());
                    System.out.println("\tPlano de fuga: " + ladrao.getPlanoDeFuga());
                    System.out.println("\tPontos de vida: " + ladrao.getPontosDeVida());
                }
                break;
            case 3:
                break;
            case 0:
                System.out.println("Arena de objetos encerrado pelo usuário");
                break;
            default:
                System.out.println("Opção invalida, tente novamente");
                break;
        }
    }

    private static void criarPersona(int opSM) {
        switch (opSM) {
            case 1:
                System.out.println("Criar Guerreiro");
                Guerreiro g = new Guerreiro();
                System.out.println("Informe o nome do Guerreiro: ");
                g.setNome(ler.nextLine());
                System.out.println("Informe a cor do olho: ");
                g.setOlho(ler.nextLine());
                System.out.println("Informe a cor do cabelo: ");
                g.setCabelo(ler.nextLine());
                System.out.println("Informe a cor da pele: ");
                g.setPele(ler.nextLine());
                System.out.println("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");
                int sexoInt = lerInt();
                boolean sexo = false;
                if (sexoInt == 1) {
                    sexo = true;// masculino
                }
                g.setSexo(sexo);
                System.out.println("Informe o armamento: ");
                g.setArmamento(ler.nextLine());
                guerreiros.add(g);
                break;
            case 2:
                System.out.println("Criar Ladrão");
                Ladrao ladrao = new Ladrao();
                System.out.println("Informe o nome do Ladrão: ");
                ladrao.setNome(ler.nextLine());
                System.out.println("Informe a cor do olho: ");
                ladrao.setOlho(ler.nextLine());
                System.out.println("Informe a cor do cabelo: ");
                ladrao.setCabelo(ler.nextLine());
                System.out.println("Informe a cor da pele: ");
                ladrao.setPele(ler.nextLine());
                System.out.println("Informe o sexo: "
                        + "\n0 - Feminino"
                        + "\n1 - Masculino"
                        + "\nDigite aqui: ");
                int sexolInt = lerInt();
                boolean sexol = false;
                if (sexolInt == 1) {
                    sexol = true;// masculino
                }
                ladrao.setSexo(sexol);
                System.out.println("Informe o plano de fuga: ");
                ladrao.setPlanoDeFuga(ler.nextLine());
                ladrões.add(ladrao);
                break;
            case 3:
                break;
            default:
                System.out.println("Opção invalida, tente novamente");
                subMenuP(opMP);
                break;
        }
    }
}