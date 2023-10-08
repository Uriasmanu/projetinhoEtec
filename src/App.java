import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        // Mensagem de boas-vindas
        JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) ao sistema da Loja SPCar");

        int opcao;

        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção" + 
        "\n1 - Sou usuário" +
        "\n2 - Sou administrador"));

        switch(opcao){
            case 1:
                JOptionPane.showMessageDialog(null,"Faça o login");
                ConfirmaSenhas confirmaSenhas = new ConfirmaSenhas();
                if (!confirmaSenhas.verificarLogin("Cliente")) {
                    return; // Encerra o programa se as credenciais forem incorretas
                }

                // Criação de uma instância da classe Fila
                Fila fila = new Fila();
                fila.verificarPrioridade();

                // Criação de uma instância da classe AluguelCarro
                AluguelCarro aluguelCarro = new AluguelCarro();
                aluguelCarro.calcularAluguel();
                break;

            case 2:
                JOptionPane.showMessageDialog(null,"Faça o login de administrador");
                ConfirmaSenhas confirmaSenhasAdmin = new ConfirmaSenhas();
                if (!confirmaSenhasAdmin.verificarLogin("Admin")) {
                    return; // Encerra o programa se as credenciais forem incorretas
                }

                // Criar uma instância da classe AdminMenu
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.menuOpcao();
                break;

            default:
            JOptionPane.showMessageDialog(null, "Opção inválida");
        }
    }
}

class ConfirmaSenhas {
    public boolean verificarLogin(String userType) {
        String login = JOptionPane.showInputDialog("Digite o seu login");
        String senhaInserida = JOptionPane.showInputDialog("Digite a sua senha");
        String[] loginCorreto = {"Admin", "Cliente"};
        String[] senhasCorretas = {"Admin", "Cliente"};

        boolean loginCorretoFlag = false;

        for (int i = 0; i < loginCorreto.length; i++) {
            if (userType.equals(loginCorreto[i]) && senhaInserida.equals(senhasCorretas[i])) {
                loginCorretoFlag = true;
                break;
            }
        }

        if (loginCorretoFlag) {
            JOptionPane.showMessageDialog(null, "Login e senha corretos. Acesso permitido!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Acesso negado.");
            return false;
        }
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

        JOptionPane.showMessageDialog(null, "Nós cobramos um valor fixo de diária de " + diarias);
        JOptionPane.showMessageDialog(null, "Então o valor a ser pago pelo aluguel do " + modelo + " é " + total);
    }
}

class AdminMenu {

    public void menuOpcao() {
        int submenu;

        submenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de alteração de dados" + 
                "\n1 - Alterar nome" +
                "\n2 - Alterar endereço" +
                "\n3 - Alterar telefone" + 
                "\n4 - Alterar RG" + 
                "\n5 - Excluir usuário"));

        switch(submenu){
            case 1:
                JOptionPane.showMessageDialog(null,"Alterar nome selecionado");
                break;

            case 2:
                JOptionPane.showMessageDialog(null,"Alterar endereço selecionado");
                break;

            case 3:
                JOptionPane.showMessageDialog(null,"Alterar telefone selecionado");
                break;

            case 4:
                JOptionPane.showMessageDialog(null,"Alterar RG selecionado");
                break;

            case 5:
                JOptionPane.showMessageDialog(null,"Excluir usuário selecionado");
                break;

            default:
                JOptionPane.showMessageDialog(null,"Opção inválida");
                break;
        }
    }
}
