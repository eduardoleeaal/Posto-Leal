package view;

import controller.PostoController;
import model.Bomba;
import model.Cliente;
import model.Combustivel;
import model.Funcionario;

import java.util.Scanner;

public class PostoView {

    Scanner sc = new Scanner(System.in);
    PostoController pc = new PostoController();

    // Combustíveis disponíveis (poderiam vir do controller)
    private Combustivel gasolina = new Combustivel("Gasolina", 6.28);
    private Combustivel etanol = new Combustivel("Etanol", 4.62);
    private Combustivel diesel = new Combustivel("Diesel", 6.10);

    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=-=-= MENU =-=-=");
            System.out.println("[1] -> Adicionar Bomba");
            System.out.println("[2] -> Cadastrar Cliente");
            System.out.println("[3] -> Cadastrar Funcionário");
            System.out.println("[4] -> Abastecer");
            System.out.println("[5] -> Gerar relatório (sem fechar caixa)");
            System.out.println("[6] -> Fechar caixa e gerar relatório");
            System.out.print("--> ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    adicionarBomba();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    cadastrarFuncionario();
                    break;
                case 4:
                    realizarAbastecimento();
                    break;
                case 5:
                    gerarRelatorio();
                    break;
                case 6:
                    continuar = false;
                    fecharSistema();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarBomba() {
        System.out.println("\n== ADICIONAR BOMBA ==");
        System.out.println("\tQual tipo de combustível utilizar?");
        System.out.println("\t[1] -> Gasolina");
        System.out.println("\t[2] -> Etanol");
        System.out.println("\t[3] -> Diesel");
        System.out.print("\t--> ");

        int tipoCombustivel = sc.nextInt();
        Combustivel combustivelEscolhido;

        switch (tipoCombustivel) {
            case 1:
                combustivelEscolhido = gasolina;
                break;
            case 2:
                combustivelEscolhido = etanol;
                break;
            case 3:
                combustivelEscolhido = diesel;
                break;
            default:
                System.out.println("Opção inválida! Usando Gasolina como padrão.");
                combustivelEscolhido = gasolina;
        }

        System.out.print("Digite a quantidade inicial de combustível (litros): ");
        double quantidadeInicial = sc.nextDouble();

        System.out.print("Digite um ID para a bomba: ");
        int idBomba = sc.nextInt();

        pc.adicionarBomba(new Bomba(idBomba, combustivelEscolhido, quantidadeInicial));
        System.out.println("\nBomba adicionada com sucesso!");
    }

    private void cadastrarCliente() {
        System.out.println("\n== CADASTRAR CLIENTE ==");
        sc.nextLine(); // Limpa o buffer

        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("CPF do cliente: ");
        String cpfCliente = sc.nextLine();

        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();

        pc.adicionarCliente(new Cliente(nomeCliente, cpfCliente, idCliente));
        System.out.println("\nCliente cadastrado com sucesso!");
    }

    private void cadastrarFuncionario() {
        System.out.println("\n== CADASTRAR FUNCIONÁRIO ==");
        sc.nextLine(); // Limpa o buffer

        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = sc.nextLine();

        System.out.print("CPF do funcionário: ");
        String cpfFuncionario = sc.nextLine();

        System.out.print("Matrícula do funcionário: ");
        int matriculaFuncionario = sc.nextInt();

        pc.adicionarFuncionario(new Funcionario(nomeFuncionario, cpfFuncionario, matriculaFuncionario));
        System.out.println("\nFuncionário cadastrado com sucesso!");
    }

    private void realizarAbastecimento() {
        System.out.println("\n== REALIZAR ABASTECIMENTO ==");

        System.out.println("\nLista de bombas disponíveis:");
        System.out.println(pc.listarBombas());

        System.out.print("ID da bomba que será utilizada: ");
        int idBomba = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        // Obter cliente
        Cliente cliente = obterCliente();

        // Obter funcionário
        System.out.print("Matrícula do funcionário responsável: ");
        int matriculaFuncionario = sc.nextInt();
        Funcionario funcionario = new Funcionario("Temp", "Temp", matriculaFuncionario); // Idealmente buscar do sistema

        // Valor do abastecimento
        System.out.print("Valor a ser abastecido (R$): ");
        double valor = sc.nextDouble();

        pc.realizarAbastecimento(idBomba, cliente, funcionario, valor);
        System.out.println("\nAbastecimento realizado com sucesso!");
    }

    private Cliente obterCliente() {
        System.out.print("Cliente cadastrado? (s/n): ");
        String resposta = sc.nextLine();

        if (resposta.toLowerCase().startsWith("s")) {
            System.out.print("ID do cliente: ");
            int idCliente = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            return new Cliente("Temp", "Temp", idCliente); // Idealmente buscar do sistema
        } else {
            System.out.print("Deseja cadastrar um novo cliente? (s/n): ");
            resposta = sc.nextLine();

            if (resposta.toLowerCase().startsWith("s")) {
                return cadastrarNovoCliente();
            } else {
                System.out.println("Registrando como cliente não identificado.");
                return new Cliente("Não identificado", "000.000.000-00", -1);
            }
        }
    }

    private Cliente cadastrarNovoCliente() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("CPF do cliente: ");
        String cpfCliente = sc.nextLine();

        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        Cliente novoCliente = new Cliente(nomeCliente, cpfCliente, idCliente);
        pc.adicionarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");

        return novoCliente;
    }

    private void gerarRelatorio() {
        System.out.println("\n== GERAR RELATÓRIO ==");
        pc.gerarRelatorioTxt();
        System.out.println("Relatório gerado com sucesso!");
    }

    private void fecharSistema() {
        System.out.println("\nFechando o sistema...");
        pc.gerarRelatorioTxt();
        sc.close();
        System.out.println("Sistema encerrado!");
    }
}