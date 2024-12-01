/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfazenda;

/**
 *
 * @author REGYANE
 */
public class Quarto {
    
int numero;
    int leitos;
    double preco;
    String situacao;  // "L" para Livre, "A" para Alugado, "R" para Reservado
    String nomeCliente;
    String telefone;
    String dataEntrada;
    String dataSaida;
    int numeroDias;
    double despesas;

    // Construtor da classe Quarto
    public Quarto(int numero, int leitos, double preco) {
        this.numero = numero;
        this.leitos = leitos;
        this.preco = preco;
        this.situacao = "L";  // Inicialmente, todos os quartos estão livres
        this.despesas = 0.0;
        this.dataEntrada = "XXXX";
        this.dataSaida = "XXXX";
        this.numeroDias = 0;
        this.nomeCliente = "";
        this.telefone = "";
    }

    // Método para calcular o valor total a ser pago pelo cliente
    public double calcularTotal() {
        return (preco * numeroDias) + despesas;
    }

    // Método para exibir as informações do quarto
    public String exibirDados() {
        return "Quarto nº " + numero + "\nLeitos: " + leitos + "\nPreço: R$ " + preco +
               "\nSituação: " + situacao + "\nNome: " + nomeCliente + "\nTelefone: " + telefone +
               "\nData Entrada: " + dataEntrada + "\nData Saída: " + dataSaida + 
               "\nNúmero de Diárias: " + numeroDias + "\nDespesas: R$ " + despesas;
    }
}
