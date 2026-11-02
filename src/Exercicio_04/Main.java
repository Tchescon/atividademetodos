package Exercicio_04;

public class Main {
    public static void main(String[] args) {
       int resultado = calcularQuadrado(5);
       System.out.println("Resultado: " + resultado);

       int resultado2 = calcularTriplo(5);
        System.out.println("Resultado: " + resultado2);
    }

    public static int calcularQuadrado(int a) {
        return a * a;

    }
    public static int calcularTriplo(int a) {
        return a * 3;

    }
    // TODO: crie calcularQuadrado(int numero), retornando int.
    // EXTRA: calcularTriplo(int numero).
}
