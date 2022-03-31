package inferfaceGrafica;

import java.util.Scanner;

import logica.Banco;

public class BancoPrincipal {
    public static void main(String[] args) {
        int opcao;
        Banco bancoUnicap = new Banco();
        Scanner s = new Scanner(System.in);
        System.out.println("Bem vindo");
        System.out.println("Este é o banco da UNICAP");
        do{
            System.out.println("Menu");
            System.out.println("1 - criar nova conta");
            System.out.println("2 - depositar na conta");
            System.out.println("3 - consultar saldo da conta");
            System.out.println("4 - sacar da conta");
            System.out.println("5 - sair");
            System.out.println("6 - transferir valores entre contas");
            System.out.println("7 - render Poupanca");
            System.out.println("Digite a opcao desejada");
            opcao = s.nextInt();
            if (opcao == 1){
                System.out.println("Qual o tipo da Conta?");
                System.out.println("1 - Conta Corrente");
                System.out.println("2 - Conta Poupanca");
                System.out.println("3 - Conta Imposto");
                int tipoConta = s.nextInt();
                int numero = 0;
                if (tipoConta == 1){
                    numero = bancoUnicap.criarConta();
                } else if (tipoConta == 2){
                    numero = bancoUnicap.criarPoupanca();
                }  else if (tipoConta == 3){
                    numero = bancoUnicap.criarContaImposto();
                }
                System.out.println("o numero da conta criada é "+numero);
            } else if (opcao == 2){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                System.out.println("Qual a quantia a ser depositada?");
                double depos = s.nextDouble();
                bancoUnicap.depositar(numero, depos);
            } else if (opcao == 3){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                double valor = bancoUnicap.consultaSaldo(numero);
                System.out.println("o saldo da conta é "+ valor);
            } else if (opcao == 4){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                System.out.println("Qual a quantia a ser sacada?");
                double saque = s.nextDouble();
                bancoUnicap.sacarConta(numero, saque);
            }  else if (opcao == 6){
                System.out.println("Qual o numero da Conta origem?");
                int numeroOri = s.nextInt();
                System.out.println("Qual o numero da Conta destino?");
                int numeroDest = s.nextInt();
                System.out.println("Qual a quantia a ser transferida?");
                double valor = s.nextDouble();
                bancoUnicap.transferir(numeroOri, numeroDest, valor);
            } else if (opcao == 7){
                System.out.println("Qual o numero da Poupanca?");
                int numeroOri = s.nextInt();
                boolean b = bancoUnicap.renderPoupanca(numeroOri);
                if (b){
                    System.out.println("redimento realizado");
                } else {
                    System.out.println("não disponível para seu tipo de conta");
                }
            }
        }while(opcao != 5);
        System.out.println("Até mais!");
        s.close();
    }
}
