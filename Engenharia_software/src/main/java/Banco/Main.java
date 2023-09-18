package Banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("Paulinho", "444444444");
        Cliente cliente2 = new Cliente("Julio", "55555555555");
        Cliente cliente3 = new Cliente("Pedro", "999999999");
        banco.criarConta(cliente);
        banco.criarConta(cliente2);
        banco.criarConta(cliente3);
        banco.login(cliente);
    }
}
