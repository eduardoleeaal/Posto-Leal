import controller.PostoController;
import model.Bomba;
import model.Cliente;
import model.Combustivel;
import model.Funcionario;

public class App {
    public static void main(String[] args) {
        Bomba b1 = new Bomba(5, new Combustivel("Gasolina", 6.80), 900);
        Bomba b2 = new Bomba(6, new Combustivel("Etanol", 5.10), 900);

        Funcionario f1 = new Funcionario("Henrique", "999.888.777-66", 2605);
        PostoController pc = new PostoController();
        pc.adicionarBomba(b1);
        pc.adicionarBomba(b2);


        pc.realizarAbastecimento(5, new Cliente("Eduardo", "111.222.333-44", 26), f1,30);
        pc.realizarAbastecimento(5, new Cliente("Luiz", "123.456.789-00", 30), f1, 25);
        pc.realizarAbastecimento(5, new Cliente("Marcos", "222.333.444-55", 31), f1, 60);
        System.out.println(pc.listarBombas());
    }
}
