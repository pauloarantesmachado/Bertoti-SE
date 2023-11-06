import Banco.Banco;
import Banco.Cliente;
import org.junit.Test;

public class BancoTest {

    Cliente cliente = new Cliente("João", "4444444444");
    Banco banco = new Banco();
    @Test
    public void criarConta(){
        banco.criarConta(cliente);
    }

    @Test
    public void logar(){
        banco.login(cliente);
    }

    @Test
    public void deletarConta(){
        banco.excluirConta(cliente);
    }

}
