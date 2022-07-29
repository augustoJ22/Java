package CinemaEstruturado;
import java.util.Scanner;

public class cinema{
    static Scanner leitor = new Scanner(System.in);
    static boolean poltronas[][] = new boolean[10][8];
    //declaração de cores
    static String vermelho = "\u001B[31m";
    static String verde = "\u001B[32m";
    static String amarelo = "\u001B[33m";
    static String nada = "\u001B[m";

    static int opcao, cadeira, fila;

    public static void main(String[] args) {
        limpar();

        Exibir();

        opcoes();
    }

    public static void limpar() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                poltronas[i][j] = false;
            }
        }
    }
    public static void Exibir(){
        //número das colunas
        for (int i = 1; i <= 8; i++) {
            System.out.print(amarelo);
            System.out.print("|  "+i+"  |");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                if(poltronas[i][j]==true){
                    System.out.print(verde);
                }else{
                    System.out.print(vermelho);
                }
                System.out.printf("|%5b|", poltronas[i][j]);
                System.out.print(nada);
            }
            //número das fileiras
            System.out.print(amarelo);
            System.out.printf("|%2d|", (i+1));
        }System.out.println("\n\n\n");
    }
    public static void opcoes() {
        System.out.print("""
                O que deseja?
                1 == Ocupar poltrona
                2 == Desocupar poltrona
                3 == Sair

                Opção: """);
                opcao = leitor.nextInt();
                execucao();
    }
    //
    public static void execucao(){
        switch(opcao){
            case 1:
            do {
                cases();
                erro();
                
            } while (cadeira>9||cadeira<0||fila>9||fila<0);
                poltronas[cadeira][fila] = true;
                Exibir();
                opcoes();
                break;

            case 2:
            do {
                cases();
                erro();

            } while (cadeira>9||cadeira<0||fila>9||fila<0);
                poltronas[cadeira][fila] = false;
                Exibir();
                opcoes();
                break;
            
            case 3:
                System.out.println("saindo...");
                break;
        }
    }
    //Entrada da posição
    public static void cases(){
        System.out.println("Escolha a poltrona\n");

                System.out.print("Fileira: ");
                fila = leitor.nextInt();
                fila--;

                System.out.print("cadeira:");
                cadeira = leitor.nextInt();
                cadeira--;
                System.out.println("\n\n");
    }
    //Invalido
    public static void erro(){
        if (cadeira>9||cadeira<0||fila>9||fila<0) {
            System.out.println("inválido... Digite uma posição existente\n\n");
        }
        switch(opcao){
            case 1:
            if (poltronas[cadeira][fila]==true) {
                System.out.println("A poltrona já está ocupada...\n\n");
                break;
            }
            case 2:
            if (poltronas[cadeira][fila]==false) {
                System.out.println("A poltrona já está desocupada...\n\n");
                break;
            }
        }
    }


}