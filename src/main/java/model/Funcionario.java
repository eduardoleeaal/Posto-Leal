package model;

public class Funcionario extends Pessoa{
    private String matricula;

    public Funcionario(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
                "\nMatricula: " + this.matricula;
    }
}
