package model;

public class Cliente extends Pessoa{
    private int idCliente;

    public Cliente(String nome, String cpf, int idCliente) {
        super(nome, cpf);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
