package model;

public class Cliente extends Pessoa{
    private String idCliente;

    public Cliente(String nome, String cpf, String idCliente) {
        super(nome, cpf);
        this.idCliente = idCliente;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("ID Cliente: " + this.idCliente);
    }
}
