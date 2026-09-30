import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o preço do produto: R$ ");
        double preco = sc.nextDouble();

        System.out.print("Digite a quantidade: ");
        int quantidade = sc.nextInt();

        double total = preco * quantidade;

        if (quantidade >= 10) {

            double desconto = total * 0.10;

            System.out.println("Desconto de 10% aplicado.");

            total = total - desconto;

        } else {

            double desconto = total * 0.05;

            total = total - desconto;
        }


        System.out.println("Valor parcial: R$ " + total);

        double frete = 20;

        System.out.println("Frete: R$ " + frete);

        total = total + frete;

        String tipoCompra =
                total >= 500 ? "Compra de alto valor" : "Compra comum";

        System.out.println(tipoCompra);

        double taxa = total * 0.02;

        System.out.printf("Taxa adicional: R$ %.2f%n", taxa);

        total = total + taxa;

        if (total >= 1000) {

            System.out.println("Cliente ganhou frete grátis.");

            total = total - frete;
        }
        System.out.printf("Valor final: R$ %.2f%n", total);
    }
}