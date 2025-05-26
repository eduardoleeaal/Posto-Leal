package model;

import model.exceptions.EstoqueInsulficienteException;

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
            throw new EstoqueInsulficienteException("Estoque insulficiente");
        }
        System.out.println("Abastecido");
        quantidadeDisponivel -= quantidade;
    }

    public void adicionarCombustivel(double quantidade){
        quantidadeDisponivel += quantidade;
    }

    public int getIdBomba() {
        return idBomba;
    }
}
