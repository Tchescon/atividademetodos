package Exercicio_07;


import java.util.Scanner;
import java.util.Locale;

public class SistemaVendas {

    static int totalVendas = 0;
    static int totalProdutos = 0;
    static double faturamento = 0;
    static double totalDescontos = 0;
    static double somaSubtotais = 0;
    static double maiorVenda = 0;
    static String clienteMaiorVenda = "";

    static void mostrarCabecalho() {
        System.out.println("\n=== SISTEMA DE VENDAS ===");
    }

    static double calcularSubtotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    static double calcularDesconto(double subtotal) {
        if (subtotal >= 500) {
            return subtotal * 0.15;
        } else if (subtotal >= 200) {
            return subtotal * 0.10;
        } else if (subtotal >= 100) {
            return subtotal * 0.05;
        }
        return 0;
    }

    static double calcularTotal(double subtotal, double desconto) {
        return subtotal - desconto;
    }

    static boolean validarVenda(double preco, int quantidade,
                                int vip, int pagamento) {
        return preco > 0 && quantidade > 0
                && (vip == 1 || vip == 2)
                && (pagamento == 1 || pagamento == 2);
    }

    static void mostrarComprovante(String cliente, String produto,
                                   int quantidade, double subtotal,
                                   double desconto, double descontoVip,
                                   double descontoPix, double total) {

        System.out.println("\n===== COMPROVANTE =====");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);

        System.out.printf(Locale.US, "Subtotal: R$ %.2f%n", subtotal);
        System.out.printf(Locale.US, "Desconto: R$ %.2f%n", desconto);
        System.out.printf(Locale.US, "Desconto VIP: R$ %.2f%n", descontoVip);
        System.out.printf(Locale.US, "Desconto PIX: R$ %.2f%n", descontoPix);
        System.out.printf(Locale.US, "Total: R$ %.2f%n", total);
    }

    static void realizarVenda(Scanner sc) {

        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Nome do produto: ");
        String produto = sc.nextLine();

        System.out.print("Preco unitario: ");
        double preco = sc.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();

        System.out.print("Cliente VIP? (1 - Sim / 2 - Nao): ");
        int vip = sc.nextInt();

        System.out.print("Pagamento (1 - PIX / 2 - Outro): ");
        int pagamento = sc.nextInt();
        sc.nextLine();

        if (!validarVenda(preco, quantidade, vip, pagamento)) {
            System.out.println("Dados invalidos! Venda nao registrada.");
            return;
        }

        double subtotal = calcularSubtotal(preco, quantidade);

        double desconto = calcularDesconto(subtotal);

        double descontoVip = 0;
        if (vip == 1) {
            descontoVip = subtotal * 0.05;
        }

        double valorAposDescontos = calcularTotal(
                subtotal, desconto + descontoVip
        );

        double descontoPix = 0;
        if (pagamento == 1) {
            descontoPix = valorAposDescontos * 0.03;
        }

        double total = calcularTotal(
                valorAposDescontos, descontoPix
        );

        totalVendas++;
        totalProdutos += quantidade;
        faturamento += total;
        totalDescontos += desconto + descontoVip + descontoPix;
        somaSubtotais += subtotal;

        if (total > maiorVenda) {
            maiorVenda = total;
            clienteMaiorVenda = cliente;
        }

        mostrarComprovante(cliente, produto, quantidade,
                subtotal, desconto, descontoVip, descontoPix, total);
    }

    static void mostrarRelatorio() {

        System.out.println("\n===== RELATORIO FINAL =====");

        System.out.println("Total de vendas: " + totalVendas);
        System.out.println("Produtos vendidos: " + totalProdutos);

        System.out.printf(Locale.US, "Faturamento: R$ %.2f%n", faturamento);
        System.out.printf(Locale.US, "Descontos: R$ %.2f%n", totalDescontos);
        System.out.printf(Locale.US, "Maior venda: R$ %.2f%n", maiorVenda);
        System.out.println("Cliente: " + clienteMaiorVenda);

        if (totalVendas > 0) {
            double ticketMedio = faturamento / totalVendas;
            double mediaProdutos = (double) totalProdutos / totalVendas;

            double percentualDescontos = 0;
            if (somaSubtotais > 0) {
                percentualDescontos =
                        (totalDescontos / somaSubtotais) * 100;
            }

            System.out.printf(Locale.US,
                    "Ticket medio: R$ %.2f%n", ticketMedio);

            System.out.printf(Locale.US,
                    "Media de produtos por venda: %.2f%n",
                    mediaProdutos);

            System.out.printf(Locale.US,
                    "Percentual de descontos: %.2f%%%n",
                    percentualDescontos);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 2) {

            mostrarCabecalho();

            System.out.println("1 - Nova venda");
            System.out.println("2 - Encerrar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                realizarVenda(sc);
            } else if (opcao != 2) {
                System.out.println("Opcao invalida!");
            }
        }

        mostrarRelatorio();
    }
}