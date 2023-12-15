import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
Faça um programa que pergunte:
• o valor de um empréstimo;
• a taxa de juros do empréstimo; e
• o tempo para pagamento.

Seu programa deverá mostrar o valor fixo da Amortização e mês a mês,
o valor pago de juros, o valor da prestação e o
saldo devedor atualizado. Ao final mostrar quanto foi o total pago nas
prestações, o total amortizado e o total pago em juros. \
Exemplo:
 */
public class Questao1 {
    static NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pergunta o valor do empréstimo
        System.out.print("Valor do empréstimo: ");
        double valorEmprestimo = scanner.nextDouble();

        // Pergunta a taxa de juros
        System.out.print("Taxa de juros: ");
        scanner.nextLine();
        String taxaJuros = scanner.nextLine();
        double taxa = Double.parseDouble(taxaJuros.replace("%", ""));

        // Pergunta o tempo para pagamento
        System.out.print("Tempo para pagamento (em meses): ");
        int tempoPagamento = scanner.nextInt();

        // Calcula o valor da amortização
        double amortizacao = valorEmprestimo / tempoPagamento;

        // Impressão inicial
        Questao1.imprimeEntrada(valorEmprestimo / tempoPagamento, valorEmprestimo, taxa);

        // Saldo devedor atual
        double saldoDevedorAtual = valorEmprestimo;

        // Total pago em juros
        double totalJuros = 0;

        // Mostra o parcelamento
        for(int i = 1; i <= tempoPagamento; i++) {
            double jurosMensal = saldoDevedorAtual * (taxa / 100);
            double parcelaMensal = jurosMensal + amortizacao;
            saldoDevedorAtual = saldoDevedorAtual - amortizacao;
            totalJuros += jurosMensal;

            Questao1.imprimeParcela(i, jurosMensal, parcelaMensal, saldoDevedorAtual);
        }

        // Calcula o total pago
        double totalPago = totalJuros + valorEmprestimo;

        // Mostra o total
        Questao1.imprimeTotal(totalPago, valorEmprestimo, totalJuros);

        scanner.close();
    }


    public static void imprimeEntrada(double amortizacao, double saldoDevedor, double taxa) {
        System.out.println("\nValor fixo da amortização " + formatter.format(amortizacao) + ", Saldo devedor total " + formatter.format(saldoDevedor)
            + " com um juros de " + taxa + "% ao mês");
    }

    public static void imprimeParcela(int numeroParcela, double juros, double valorParcela, double saldoDevedorAtual) {
        System.out.println("Parcela " + numeroParcela + " | " + "Juros: " + formatter.format(juros) + " | " + "Prestação: "
                            + formatter.format(valorParcela) + " | " + "Saldo devedor: " + formatter.format(saldoDevedorAtual));
    }


    public static void imprimeTotal(double totalPago, double valorAmortizacao, double totalJuros) {
        System.out.println("Total: Prestação " + formatter.format(totalPago) + ", Juros " + formatter.format(totalJuros)
                            + ", Amortização " + formatter.format(valorAmortizacao));
    }
}
