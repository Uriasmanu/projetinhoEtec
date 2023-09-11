import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        // Mensagem de boas-vindas
        JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) ao sistema da Loja SPCar");

        String login = JOptionPane.showInputDialog("Digite o seu login");
        String senha = JOptionPane.showInputDialog("Digite a sua senha");

        if (login.equals("aluno") && senha.equals("aluno")) {
            JOptionPane.showMessageDialog(null, "Acesso Liberado");
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }

        // Criação de uma instância da classe Fila
        Fila fila = new Fila();
        fila.verificarPrioridade();
        
        // Criação de uma instância da classe AluguelCarro
        AluguelCarro aluguelCarro = new AluguelCarro();
        aluguelCarro.calcularAluguel();
    }
}

class Fila {
    private int idade;

    public void verificarPrioridade() {
        String entradaIdade = JOptionPane.showInputDialog("Por gentileza, antes de entrar na fila, digite a sua idade: ");
        idade = Integer.parseInt(entradaIdade);

        if (idade >= 80) {
            JOptionPane.showMessageDialog(null, "O(A) senhor(a) irá para a fila de prioridade especial");
        } else if (idade >= 60) {
            JOptionPane.showMessageDialog(null, "O(A) senhor(a) irá para a fila de prioridade");
        } else {
            JOptionPane.showMessageDialog(null, "O(A) senhor(a) irá para a fila normal");
        }
    }
}

class AluguelCarro {
    private String modelo;
    private int dias;
    private int km;
    private int diarias = 30;
    private double total;
    private double taxaKm = 0.20;

    public void calcularAluguel() {
        JOptionPane.showMessageDialog(null, "A seguir o sistema de aluguel de carros");

        modelo = JOptionPane.showInputDialog("Por gentileza, digite o modelo do carro escolhido");

        String entradaDias = JOptionPane.showInputDialog("Digite quantos dias você utilizou o " + modelo);
        dias = Integer.parseInt(entradaDias);

        String entradaKm = JOptionPane.showInputDialog("Digite quantos km você rodou com o " + modelo);
        km = Integer.parseInt(entradaKm);

        total = (dias * diarias) + (km * taxaKm);

        JOptionPane.showMessageDialog(null, "O valor a ser pago pelo aluguel do " + modelo + " é " + total);
    }
}
