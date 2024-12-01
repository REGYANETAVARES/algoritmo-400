/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelfazenda;

import javax.swing.JOptionPane;

/**
 *
 * @author REGYANE
 */
public class HotelFazenda {

    public static void main(String[] args) {
        Quarto[] quartos = new Quarto[50];  // Vetor de 50 quartos
        int op;
        int quartoEscolhido;
        String resp;
        String nomeCliente;
        String telefoneCliente;
        double valorDespesa;

        // Inicializa os quartos
        for (int i = 0; i < 50; i++) {
            quartos[i] = new Quarto(i + 1, 5, 30.0);  // Cada quarto tem 5 leitos e preço inicial de R$30
        }

        do {
            // Exibe o menu para o usuário
            String menu = "\n\nHotel Fazenda Sucesso\n" +
                          "1. Cadastrar quartos\n" +
                          "2. Listar todos os quartos\n" +
                          "3. Listar quartos desocupados\n" +
                          "4. Aluguel/Reserva quarto\n" +
                          "5. Entrar despesas extras\n" +
                          "6. Calcular despesa do quarto\n" +
                          "7. Sair\n" +
                          "Escolha uma opção: ";

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1: // Cadastrar quartos
                    for (int i = 0; i < 50; i++) {
                        if (quartos[i].situacao.equals("L")) { // Só permite cadastro de quartos livres
                            int leitos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de leitos do quarto " + (i + 1)));
                            double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do quarto " + (i + 1)));
                            quartos[i].leitos = leitos;
                            quartos[i].preco = preco;
                            JOptionPane.showMessageDialog(null, "Quarto " + (i + 1) + " cadastrado com sucesso!");
                            break;
                        }
                    }
                    break;

                case 2: // Listar todos os quartos
                    StringBuilder listaQuartos = new StringBuilder();
                    for (int i = 0; i < 50; i++) {
                        listaQuartos.append(quartos[i].exibirDados()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, listaQuartos.toString());
                    break;

                case 3: // Listar quartos desocupados
                    StringBuilder quartosLivres = new StringBuilder();
                    for (int i = 0; i < 50; i++) {
                        if (quartos[i].situacao.equals("L")) {
                            quartosLivres.append("Quarto nº ").append(i + 1).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, quartosLivres.length() == 0 ? "Nenhum quarto livre." : quartosLivres.toString());
                    break;

                case 4: // Aluguel ou reserva
                    resp = JOptionPane.showInputDialog("Digite 'A' para aluguel ou 'R' para reserva:");
                    if (resp.equalsIgnoreCase("A") || resp.equalsIgnoreCase("R")) {
                        quartoEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto (1-50):"));
                        if (quartos[quartoEscolhido - 1].situacao.equals("L")) {
                            nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                            telefoneCliente = JOptionPane.showInputDialog("Digite o telefone do cliente:");
                            quartos[quartoEscolhido - 1].situacao = resp.equalsIgnoreCase("A") ? "A" : "R";
                            quartos[quartoEscolhido - 1].nomeCliente = nomeCliente;
                            quartos[quartoEscolhido - 1].telefone = telefoneCliente;
                            quartos[quartoEscolhido - 1].dataEntrada = JOptionPane.showInputDialog("Digite a data de entrada:");
                            quartos[quartoEscolhido - 1].dataSaida = JOptionPane.showInputDialog("Digite a data de saída:");
                            quartos[quartoEscolhido - 1].numeroDias = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de dias para a estadia:"));
                            JOptionPane.showMessageDialog(null, "Quarto alugado/reservado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Quarto já está ocupado!");
                        }
                    }
                    break;

                case 5: // Entrar despesas extras
                    quartoEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto (1-50):"));
                    valorDespesa = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da despesa extra:"));
                    quartos[quartoEscolhido - 1].despesas += valorDespesa;
                    JOptionPane.showMessageDialog(null, "Despesa extra adicionada com sucesso!");
                    break;

                case 6: // Calcular despesa do quarto
                    quartoEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto (1-50):"));
                    double total = quartos[quartoEscolhido - 1].calcularTotal();
                    JOptionPane.showMessageDialog(null, "Valor total a ser pago: R$ " + total);
                    break;

                case 7: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        } while (op != 7);
    }
}