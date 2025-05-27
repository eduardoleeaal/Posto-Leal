package model;

import model.exceptions.EstoqueInsuficienteException;

public class Bomba {
    private int idBomba;
    private double quantidadeDisponivel = 0.0;
    private Combustivel combustivel;

    public Bomba(int idBomba, double quantidadeDisponivel, Combustivel combustivel) {
        this.idBomba = idBomba;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.combustivel = combustivel;
    }
    public Bomba(int idBomba, double quantidadeDisponivel) {
        this.idBomba = idBomba;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.combustivel = null;
    }
    public Bomba(int idBomba) {
        this.idBomba = idBomba;
        this.quantidadeDisponivel = 0.0;
        this.combustivel = null;
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
        return "Bomba{" +
                "idBomba=" + idBomba +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", combustivel=" + combustivel +
                '}';
    }
}
