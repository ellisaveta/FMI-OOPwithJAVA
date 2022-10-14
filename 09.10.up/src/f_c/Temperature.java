package f_c;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Въведи 1 за Fahrenheit -> Celsius или" +
                " 2 за Celsius -> Fahrenheit: ");
        int choice = input.nextInt();
        double celsius;
        double fahrenheit;
        if(choice==1) {

            System.out.print("Въведи температура по Fahrenheit: ");
            fahrenheit = input.nextDouble();

            celsius = 5.0 / 9.0 * (fahrenheit - 32);
            System.out.println("Температурата по Целзий е: " + celsius);
        }
        else if(choice==2){
            System.out.print("Въведи температура по Celsuis: ");
            celsius = input.nextDouble();
            fahrenheit = 9.0 / 5.0 * celsius + 32;
            System.out.printf("Температура по Fahrenheit: %.2f", fahrenheit);
        }
        else
        {
            System.out.println("Incorrect input!");
        }
    }
}
