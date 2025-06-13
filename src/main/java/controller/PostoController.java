package controller;

import model.Abastecimento;
import model.Bomba;
import model.Cliente;
import model.Funcionario;
import model.exceptions.EstoqueInsuficienteException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostoController {
    private Map<Integer, Bomba> bombas;
    private List<Abastecimento> historicoAbastecimentos;

    private Map<Integer, Funcionario> funcionarios;
    private Map<Integer, Cliente> clientes;

    public PostoController() {
        this.bombas = new HashMap<>();
        this.historicoAbastecimentos = new ArrayList<>();
        this.funcionarios = new HashMap<>();
        this.clientes = new HashMap<>();
    }

    /**
     * Orquestra a operação de abastecimento.
     * Recebe dados da view, utiliza o modelo para processar e atualiza o estado.
     */
    public void realizarAbastecimento(int idBomba, Cliente cliente, Funcionario funcionario, double valor) {
        // Lógica a ser implementada:
        // 1. Encontrar a bomba no mapa 'bombas'.
        for (Bomba bomba : bombas.values()) {
            if (idBomba == bomba.getIdBomba()) {
                try {
                    double quantidade = valor/bomba.getCombustivel().getPrecoPorLitro();
                    bomba.abastecer(quantidade);
                    historicoAbastecimentos.add(new Abastecimento(bomba, cliente, funcionario, quantidade, valor, LocalDateTime.now()));
                } catch (NullPointerException e) {
                    System.err.println("Erro: Bomba ou combustível não inicializados.");
                } catch (ArithmeticException e) {
                    System.err.println("Erro de cálculo ao abastecer: Não é possível dividir por zero");
                } catch (EstoqueInsuficienteException e) {
                    System.err.println("Erro ao abastecer: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Gera um arquivo de texto com o histórico de todos os abastecimentos.
     */
    public void gerarRelatorioTxt() {
        StringBuilder sb = new StringBuilder();
        for (Abastecimento abastecimento : historicoAbastecimentos) {
            sb.append(abastecimento.gerarLog()).append(System.lineSeparator());
        }
        try (java.io.FileWriter writer = new java.io.FileWriter("relatorio_abastecimentos_"+LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM_HH-mm"))+".txt")) {
            writer.write(sb.toString());
        } catch (java.io.IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }

    public String listarBombas(){
        StringBuilder bombasLista = new StringBuilder();
        for (Bomba bomba : bombas.values()) {
            bombasLista.append(bomba.toString());
        }
        return bombasLista.toString();
    }

    public void adicionarFuncionario(Funcionario funcionario){
        this.funcionarios.put(funcionario.getMatricula(), funcionario);
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.put(cliente.getIdCliente(), cliente);
    }
    public void adicionarBomba(Bomba bomba) {
        this.bombas.put(bomba.getIdBomba(), bomba);
    }
}
