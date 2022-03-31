package logica;

import java.util.LinkedList;
import java.util.Random;

public class Banco {
    private LinkedList<Conta> contas = new LinkedList<Conta>();

    public int criarContaImposto() {
        Random r = new Random();
        int numero = Math.abs(r.nextInt());
        ContaImposto c = new ContaImposto(numero);
        contas.add(c);
        return numero;
    }
    
    public int criarConta() {
        Random r = new Random();
        int numero = Math.abs(r.nextInt());
        Conta c = new Conta(numero);
        contas.add(c);
        return numero;
    }

    public int criarPoupanca() {
        Random r = new Random();
        int numero = Math.abs(r.nextInt());
        Poupanca p = new Poupanca(numero);
        contas.add(p);
        return numero;
    }

    public void depositar(int numero, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero){
                conta.depositar(valor);
            }
        }
    }

    public double consultaSaldo(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero){
                return conta.getSaldo();
            }
        }
        return -1;
    }

    public void sacarConta(int numero, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero){
                conta.sacar(valor);
            }
        }
    }

    public void transferir(int numeroOri, int numeroDest, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroOri){
                conta.sacar(valor);
            }

            if (conta.getNumero() == numeroDest){
                conta.depositar(valor);
            }
        }
    }

    public boolean renderPoupanca(int numeroOri) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroOri){
                if (conta instanceof Poupanca){
                    Poupanca p = (Poupanca) conta;
                    p.renderJuros();
                    return true;
                }
            }
        }
        return false;
    }
}
