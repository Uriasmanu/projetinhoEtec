import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int idade;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Por gentileza, antes de entrar na fila, digite a sua idade: ");
        idade = leitor.nextInt();

        if (idade >= 60) {
            if (idade >= 80) {
                System.out.println("O(A) senhor(a) irá para a fila de prioridade especial");
            } else {
                System.out.println("O(A) senhor(a) irá para a fila de prioridade");
            }
        } else {
            System.out.println("O(A) senhor(a) irá para a fila normal\n");
        }

        // Criar uma instância da classe AluguelCarro e chamar seu construtor
        AluguelCarro aluguelCarro = new AluguelCarro();
    }
}

class AluguelCarro {
    String modelo;
    int dias;
    int km;
    int diarias = 30;
    double total;
    double taxaKm = 0.20;

    public AluguelCarro() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Seja bem-vindo(a) ao sistema da Loja SPCar");

        System.out.println("Por gentileza, digite o modelo do carro escolhido");
        modelo = leitor.nextLine();

        System.out.println("Digite quantos dias você utilizou o " + modelo);
        dias = leitor.nextInt();

        System.out.println("Digite quantos km você rodou com o " + modelo);
        km = leitor.nextInt();
        total = (dias * diarias) + (km * taxaKm);
        System.out.println("O valor a ser pago pelo aluguel do " + modelo + " é " + total);
    }
}
