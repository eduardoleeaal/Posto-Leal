package model;

public class Combustivel {
    private String nome;
    private double precoPorLitro;

    public Combustivel(String nome, double precoPorLitro) {
        this.nome = nome;
        this.precoPorLitro = precoPorLitro;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(double precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }
}
