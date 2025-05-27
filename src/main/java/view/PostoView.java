package view;

import controller.PostoController;
import model.Bomba;
import model.Cliente;
import model.Combustivel;
import model.Funcionario;

import java.util.Scanner;

public class PostoView {
    PostoController pc = new PostoController();
    Scanner sc = new Scanner(System.in);
    Combustivel gasolina = new Combustivel("Gasolina", 6.28);
    Combustivel etanol = new Combustivel("Etanol", 4.62);
    Combustivel diesel = new Combustivel("Diesel", 6.10);
    int opt;
    int tipoCombust;


    public void exibirMenu(){
        System.out.println("=-=-= MENU =-=-=");
        System.out.println("[1] -> Adicionar Bomba");
        System.out.println("[2] -> Cadastrar Cliente");
        System.out.println("[3] -> Cadastrar Funcionário");
        System.out.println("[4] -> Abastecer");
        System.out.println("[5] -> Gerar relatório");
        System.out.println("[6] -> Fechar caixa");
        System.out.print("--> ");
        opt = sc.nextInt();

        switch (opt){
            case 1:
                System.out.println("\tQual tipo de combustivel utilizar? (Padrão: Gasolina) ");
                System.out.println("\t[1] -> Etanol");
                System.out.println("\t[2] - Diesel");
                System.out.println("\tDigite qualquer número para definir Gasolina");
                System.out.print("\t--> ");
                tipoCombust = sc.nextInt();
                Combustivel tipoEscolhido;
                switch (tipoCombust){
                    case 1:
                        tipoEscolhido = etanol;
                        break;
                    case 2:
                        tipoEscolhido = diesel;
                        break;
                    default:
                        tipoEscolhido = gasolina;
                        break;
                }
                System.out.println("Quantidade ínicial de combustível: ");
                double qntIncial = sc.nextDouble();
                System.out.print("Digite um ID para a bomba: ");
                int id = sc.nextInt();
                pc.adicionarBomba(new Bomba(id, tipoEscolhido, qntIncial));
                System.out.println("Bomba Adicionada!");
                break;
            case 2:
                sc.nextLine();
                System.out.print("Nome do cliente: ");
                String nomeCliente = sc.nextLine();
                System.out.print("CPF CLIENTE: ");
                String cpfCliente = sc.nextLine();
                System.out.println("ID Cliente: ");
                int idCliente = sc.nextInt();
                pc.adicionarCliente(new Cliente(nomeCliente, cpfCliente, idCliente));
                System.out.println("Cliente Adicionado!");
                break;
            case 3:
                sc.nextLine();
                System.out.print("Nome do funcionário: ");
                String nomeFuncionario = sc.nextLine();
                System.out.print("CPF FUNCIONÁRIO: ");
                String cpfFuncionario = sc.nextLine();
                System.out.println("Matricula Funcionário: ");
                int matriculaFuncionario = sc.nextInt();
                pc.adicionarFuncionario(new Funcionario(nomeFuncionario, cpfFuncionario, matriculaFuncionario));
                System.out.println("Funcionário Adicionado!");
                break;
            case 4:
                pc.listarBombas();
                System.out.print("ID da bomba que será utilizada: ");
                int idBomba = sc.nextInt();
                sc.nextLine();
                System.out.print("Cliente cadastrado? (s/n)");
                String clienteCadas = sc.nextLine();
                if (clienteCadas.toLowerCase().contains("s")){
                    System.out.print("ID Cliente: ");
                    int idClienteC = sc.nextInt();
                } else {
                    sc.nextLine();
                    System.out.println("Cadastrar Cliente? (s/n)");
                    String cadasCliente = sc.nextLine();
                    if (cadasCliente.toLowerCase().contains("s")){
                        System.out.print("Nome do cliente: ");
                        String nomeClienteN = sc.nextLine();
                        System.out.print("CPF CLIENTE: ");
                        String cpfClienteN = sc.nextLine();
                        System.out.println("ID Cliente: ");
                        int idClienteN = sc.nextInt();
                        pc.adicionarCliente(new Cliente(nomeClienteN, cpfClienteN, idClienteN));
                        System.out.println("Cliente Adicionado!");
                    }
                }

                pc.realizarAbastecimento(idBomba, cliente, funcionario, valor);


        }

    }
}
