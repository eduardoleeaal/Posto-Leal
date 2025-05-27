package model;

public class Funcionario extends Pessoa{
    private int matricula;

    public Funcionario(String nome, String cpf, int matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
                "\nMatricula: " + this.matricula;
    }

    public int getMatricula() {
        return matricula;
    }
}
