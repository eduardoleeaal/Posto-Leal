package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Abastecimento implements Registro{
    private Bomba bomba;
    private Cliente cliente;
    private Funcionario funcionario;
    private double litros;
    private double valorTotal;
    private LocalDateTime dataHora;

    public Abastecimento(Bomba bomba, Cliente cliente, Funcionario funcionario, double litros, double valorTotal, LocalDateTime dataHora) {
        this.bomba = bomba;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.litros = litros;
        this.valorTotal = valorTotal;
        this.dataHora = dataHora;
    }

    @Override
    public String gerarLog() {
        return "ID Bomba: " + bomba.getIdBomba() +
                ",\nCPF Cliente: " + cliente.getCpf() +
                ",\nLitros Abastecidos: " + litros +
                ",\nValor total: R$" + valorTotal +
                ",\nFuncionário: " + funcionario.getNome() +
                ",\n  Matricula: " + funcionario.getMatricula() +
                ",\nData/Hora: " + dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n======";
    }
}
