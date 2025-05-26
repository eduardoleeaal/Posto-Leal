package model;

public class Funcionario extends Pessoa{
    private String matricula;

    public Funcionario(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Matricula: " + this.matricula);
    }
}
