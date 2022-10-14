package celsius;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        double celsius;
        double fahrenheit;
        Scanner input = new Scanner(System.in);

        System.out.print("Въведи температура по Fahrenheit: ");
        fahrenheit = input.nextDouble();

        celsius = 5.0 / 9.0 * (fahrenheit-32);
        System.out.println("Температурата по Целзий е: " + celsius);
    }
}
