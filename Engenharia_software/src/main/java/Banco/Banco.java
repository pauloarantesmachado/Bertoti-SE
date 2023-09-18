package Banco;

import java.util.ArrayList;
public class Banco {
    private ArrayList<Cliente> listaCliente = new ArrayList<>();
    private Conta novaConta;
    public Conta criarConta( Cliente cliente){
        if(verificarConta(cliente)){
            System.out.println("Conta já existente");
            return null;
        }
        System.out.println("Nova conta criada");
        novaConta = new Conta(cliente);
        listaCliente.add(cliente);
        return novaConta;
    }

    public  Cliente login(Cliente cliente){
        if(verificarConta(cliente)){
            System.out.println("Usuário Logado");
            for(Cliente objeto: listaCliente){
                if(cliente.getCpf().equals(objeto.getCpf())){
                    return objeto;
                }
            }
        }
        System.out.println("Pof favor realizar cadastro de conta");
        return null;
    }

    public void excluirConta(Cliente cliente){
        if(verificarConta(cliente)){
            System.out.println("Usuário deletado");
        }
        System.out.println("Usuário não cadastrado");
    }

    private boolean verificarConta(Cliente cliente){
        for (Cliente x: listaCliente)
            if(cliente.getCpf().equals(x.getCpf())){
                return true;
            }
        return false;
    }

}


