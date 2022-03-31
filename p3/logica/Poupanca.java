package logica;

public class Poupanca extends Conta {

    public Poupanca(int numero) {
        super(numero);
    }

    public void renderJuros() {
        saldo += saldo * 0.01f;
    }
}
