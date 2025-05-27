package model;

import model.exceptions.EstoqueInsuficienteException;

public class Bomba {
    private int idBomba;
    private double quantidadeDisponivel = 0.0;
    private Combustivel combustivel;

    public Bomba(int idBomba, Combustivel combustivel, double quantidadeDisponivel) {
        this.idBomba = idBomba;
        this.combustivel = combustivel;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }


    public void abastecer(double quantidade) {
        if (quantidade > quantidadeDisponivel) {
            throw new EstoqueInsuficienteException("Estoque insuficiente");
        }
        quantidadeDisponivel -= quantidade;
    }

    public void adicionarCombustivel(double quantidade){
        quantidadeDisponivel += quantidade;
    }

    public int getIdBomba() {
        return idBomba;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    @Override
    public String toString() {
        return "\nBomba ID: " + idBomba +
                "\nQuantidade de Combustivel: " + quantidadeDisponivel +
                "\nCombustivel: " + combustivel.getNome() + "\n";
    }
}
