package model;

import model.exceptions.EstoqueInsuficienteException;

public class Bomba {
    private int idBomba;
    private double quantidadeDisponivel;
    private Combustivel combustivel;

    public Bomba(int idBomba, double quantidadeDisponivel, Combustivel combustivel) {
        this.idBomba = idBomba;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.combustivel = combustivel;
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
}
