package controller;

import model.Abastecimento;
import model.Bomba;
import model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostoController {
    private Map<Integer, Bomba> bombas;
    private List<Abastecimento> historicoAbastecimentos;

    public PostoController() {
        this.bombas = new HashMap<>();
        this.historicoAbastecimentos = new ArrayList<>();
    }

    /**
     * Orquestra a operação de abastecimento.
     * Recebe dados da view, utiliza o modelo para processar e atualiza o estado.
     */
    public void realizarAbastecimento(int idBomba, Cliente cliente, double valor) {
        // Lógica a ser implementada:
        // 1. Encontrar a bomba no mapa 'bombas'.
        // 2. Calcular os litros a partir do valor.
        // 3. Chamar o método 'bomba.abastecer(litros)' dentro de um try-catch.
        // 4. Se sucesso, criar um novo objeto Abastecimento e adicionar ao 'historicoAbastecimentos'.
        // 5. Se falhar (exceção), tratar o erro.
    }

    /**
     * Gera um arquivo de texto com o histórico de todos os abastecimentos.
     */
    public void gerarRelatorioTxt() {
        // Lógica a ser implementada:
        // 1. Criar um StringBuilder ou similar.
        // 2. Iterar sobre 'historicoAbastecimentos'.
        // 3. Para cada abastecimento, chamar 'abastecimento.gerarLog()' e adicionar à string.
        // 4. Usar as classes de I/O do Java para escrever a string final em um arquivo .txt.
    }

    // Você pode adicionar outros métodos auxiliares conforme a necessidade,
    // por exemplo, um método para adicionar bombas ao mapa para testes.
    public void adicionarBomba(Bomba bomba) {
        this.bombas.put(bomba.getIdBomba(), bomba);
    }
}
