package Exercicio_03;

public class Main {
    public static void main(String[] args) {
        mostrarDobro(8);
        mostrarSoma(10, 5);
        mostrarMaior(10, 11);

    }
    public static void mostrarDobro(int valor1) {
        valor1 = valor1 * 2;
        System.out.println("o dobro é: " + valor1);
    }
    public static void mostrarSoma(int valor2, int valor3) {
        int soma = 0;
        soma = valor2 + valor3;
        System.out.println("a soma é: " + soma);
    }
    public static void mostrarMaior(int a, int b) {
        if(a > b) {
            System.out.println("A é maior que B");
        } else {
            System.out.println("B é maior que A");
        }
    }
}
