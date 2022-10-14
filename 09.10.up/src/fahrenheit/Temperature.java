package fahrenheit;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        double fahrenheit;
        double celsius;
        Scanner input = new Scanner(System.in);

        System.out.print("Въведи температура по Celsuis: ");
        celsius = input.nextDouble();
        fahrenheit = 9.0 / 5.0 * celsius + 32;
        //%d - int
        //%f - double
        //%s - string
        System.out.printf("Температура по Fahrenheit: %.2f", fahrenheit);
    }
}
