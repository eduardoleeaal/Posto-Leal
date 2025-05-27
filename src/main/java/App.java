import controller.PostoController;
import model.Bomba;
import model.Cliente;
import model.Combustivel;

public class App {
    public static void main(String[] args) {
        Bomba b1 = new Bomba(5, 900, new Combustivel("Gasolina", 5.60));
        Bomba b2 = new Bomba(6, 900, null);

        PostoController pc = new PostoController();
        pc.adicionarBomba(b1);
        pc.adicionarBomba(b2);

        pc.realizarAbastecimento(5, new Cliente("Eduardo", "111.222.333-44", "26"), 60);
        pc.realizarAbastecimento(5, new Cliente("Luiz", "123.456.789-00", "30"), 20);
        pc.realizarAbastecimento(5, new Cliente("Marcos", "222.333.444-55", "31"), 60);
        pc.gerarRelatorioTxt();
    }
}
