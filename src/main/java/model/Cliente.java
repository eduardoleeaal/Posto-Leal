package model;

public class Cliente extends Pessoa{
    private String idCliente;

    public Cliente(String nome, String cpf, String idCliente) {
        super(nome, cpf);
        this.idCliente = idCliente;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
                "\nID Cliente: " + this.idCliente;
    }
}
