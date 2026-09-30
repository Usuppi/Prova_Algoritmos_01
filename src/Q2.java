import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe o seu nome: ");
        String name = sc.nextLine();

        System.out.printf("Informe a sua idade: ");
        int idd = sc.nextInt();

        System.out.printf("Informe a sua altura (ex: 1,75): ");
        double alt = sc.nextDouble();

        sc.nextLine();

        System.out.printf("Você possui alguma deficiencia? (s/n): ");
        String def = sc.nextLine();

        System.out.printf("Você é estudante? (s/n): ");
        String est = sc.nextLine();

        System.out.printf("Irá vir em dia da semana ou no final de semana?: ");
        String dia = sc.nextLine();

        System.out.printf("Irá visitar no período da manhã ou da tarde?: ");
        String hor = sc.nextLine();

        String statusBrinquedo;
        if (idd > 12 && alt >= 1.50) {
            statusBrinquedo = "Permitido";
        } else {
            statusBrinquedo = "Negado";
        }

        double valorBase = 100.00;
        double descPor = 0.0;
        String descMot = "Nenhum";

        if (def.equalsIgnoreCase("sim")) {
            descPor = 0.50;
            descMot = "Pessoa com deficiência";
        } else if (idd <= 10) {
            descPor = 0.40;
            descMot = "10 anos ou menos";
        } else if (est.equalsIgnoreCase("sim") || idd >= 60) {
            descPor = 0.35;
            descMot = (idd >= 60) ? "60 anos ou mais" : "Estudante";
        }

        double valorDesconto = valorBase * descPor;
        double valorComDesc = valorBase - valorDesconto;

        double valorAcresTotal = 0.0;
        if (dia.equalsIgnoreCase("final de semana")) {
            valorAcresTotal += valorComDesc * 0.25;
        }
        if (hor.equalsIgnoreCase("manhã") || hor.equalsIgnoreCase("manha")) {
            valorAcresTotal += valorComDesc * 0.15;
        }

        double valorFinal = valorComDesc + valorAcresTotal;

        double valorPromocaoEspecial = 0.0;
        boolean condEst = est.equalsIgnoreCase("sim");
        boolean condIdd = (idd >= 14 && idd <= 17);
        boolean condHor = hor.equalsIgnoreCase("tarde");
        boolean condDia = dia.equalsIgnoreCase("dia da semana");

        if (condEst && condIdd && condHor && condDia) {
            valorPromocaoEspecial = valorFinal * 0.07;
            valorFinal -= valorPromocaoEspecial;
        }

        System.out.println("\n----- RESUMO DO INGRESSO -----");
        System.out.println("Nome: " + name);
        System.out.println("Categoria de desconto: " + descMot);
        System.out.printf("Valor do desconto: R$ %.2f\n", valorDesconto);
        System.out.printf("Valor dos acréscimos: R$ %.2f\n", valorAcresTotal);
        System.out.printf("Valor da promoção especial: R$ %.2f\n", valorPromocaoEspecial);
        System.out.printf("Valor final: R$ %.2f\n", valorFinal);
        System.out.println("Status do brinquedo radical: " + statusBrinquedo);
    }
}