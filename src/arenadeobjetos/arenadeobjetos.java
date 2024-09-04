package arenadeobjetos;

import java.util.Scanner;

public class arenadeobjetos {
    static Scanner ler = new Scanner(System.in);

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
    }

    public static void menuP() {
        String menu;
        menu = "1 - Criar Personagens"
                + "\n2 - Listar Personagens"
                + "\n3 - Batalha"
                + "\n0 - Sair do Jogo";
        System.out.println(menu);
    }

    public static void subMenuP(int omP) {
        String subMenu;
        switch (omP) {
            case 1:

                break;
            case 2:

                break;
            case 3:
                break;
            default:
                break;
        }
    }
}
