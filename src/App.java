import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String Entradaidade;
        int idade;

        Entradaidade = JOptionPane.showInputDialog("Por gentileza, antes de entrar na fila, digite a sua idade: ");

        idade = Integer.parseInt(Entradaidade);

        if (idade >= 60) {
            if (idade >= 80) {
                JOptionPane.showMessageDialog(null,"O(A) senhor(a) irá para a fila de prioridade especial");
            } else {
                JOptionPane.showMessageDialog(null,"O(A) senhor(a) irá para a fila de prioridade");
            }
        } else {
            JOptionPane.showMessageDialog(null,"O(A) senhor(a) irá para a fila normal\n");
        }

        // Criar uma instância da classe AluguelCarro e chamar seu construtor
       AluguelCarro aluguelCarro = new AluguelCarro();
    }
}

class AluguelCarro {
    String modelo;
    String EntradaDias;
    int dias;
    String EntradaKm;
    int km;
    int diarias = 30;
    double total;
    double taxaKm = 0.20;

    public AluguelCarro() {

        JOptionPane.showMessageDialog(null,"Seja bem-vindo(a) ao sistema da Loja SPCar");

        modelo = JOptionPane.showInputDialog("Por gentileza, digite o modelo do carro escolhido");

        EntradaDias = JOptionPane.showInputDialog("Digite quantos dias você utilizou o " + modelo);

        dias = Integer.parseInt(EntradaDias);

        EntradaKm = JOptionPane.showInputDialog("Digite quantos km você rodou com o " + modelo);
        km = Integer.parseInt(EntradaKm);

        total = (dias * diarias) + (km * taxaKm);

        JOptionPane.showMessageDialog(null, "O valor a ser pago pelo aluguel do " + modelo + " é " + total);
    }
}
