import Banco.Cliente;
import Banco.Conta;
import org.junit.Test;

public class ContaTest {
    Cliente cliente = new Cliente("Pedro", "2222222222");
    Conta conta = new Conta(cliente);

    @Test
    public void depositar(){
        conta.depositar(1000);
    }

    @Test
    public void verSaldo(){
        conta.saldo();
    }
}
