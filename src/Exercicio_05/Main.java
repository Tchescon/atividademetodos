package Exercicio_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a nota 1: ");
        double a = sc.nextDouble();
        System.out.println("Digite a nota 2: ");
        double b = sc.nextDouble();

        double media = calcularMedia(a, b);
        System.out.println(media);
        boolean aprovado = estaAprovado(media);
        mostrarResultado(media, aprovado);
    }

    public static double calcularMedia(double a, double b) {
        double media = (a + b) / 2;
        return media;


}
public static boolean estaAprovado(double media) {
        return media >= 7;
}
public static void mostrarResultado(double media, boolean aprovado) {
    System.out.println("Média: " + media);
    if (aprovado) {
        System.out.println("Situação: APROVADO!");
    } else {
        System.out.println("Situação: REPROVADO!");
    }
}
    }
// TODO: crie calcularMedia(double n1, double n2), retornando double.
// TODO: crie estaAprovado(double media), retornando boolean.
// TODO: crie mostrarResultado(double media, boolean aprovado), sem retorno.