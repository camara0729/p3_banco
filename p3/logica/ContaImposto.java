package logica;

public class ContaImposto extends Conta{

    public ContaImposto(int numero) {
        super(numero);
    }

    @Override
    public void depositar(double quantia) {
        quantia = quantia - quantia*0.001;
        super.depositar(quantia);
        //saldo += valor;
    }
}
