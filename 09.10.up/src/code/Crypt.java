package code;

import java.util.Scanner;

public class Crypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Въведи 4-цифрено число: ");
        number = input.nextInt();
        if(number > 999 && number < 10_000){
            int digit4 = number % 10;
            number /= 10;
            int digit3 = number % 10;
            number /= 10;
            int digit2 = number % 10;
            int digit1 = number / 10;
            digit1 += 7;
            digit2 += 7;
            digit3 += 7;
            digit4 += 7;
            digit1 %= 10;
            digit2 %= 10;
            digit3 %= 10;
            digit4 %= 10;
            int temp = digit1;
            digit1 = digit3;
            digit3 = temp;
            temp = digit2;
            digit2 = digit4;
            digit4 = temp;
            int code = 1000 * digit1 + 100 * digit2 +
                    10 * digit3 + digit4;
            System.out.printf("Криптираните данни са: %04d", code);
        }else{
            System.out.println("Невалиден вход!");
        }
    }
}
