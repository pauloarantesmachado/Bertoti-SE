package Banco;

import java.util.Random;

public class Conta {
    Random random = new Random();
    private int numero;
    private float saldo;
    private Cliente titular;

    public int getNumero() {
        return numero;
    }

    public Conta(Cliente titular) {
        this.titular = titular;
        this.saldo = 0;
        this.numero = random.nextInt();
    }

    public float saldo(){
        return this.saldo;
    }

    public void depositar(float valor){

    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}
