package fiveDigit;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Въведи 5-цифрено число: ");
        number = input.nextInt();
        int originalNumber = number;
        if(number<0) {
            number = -number;
        }
        if(number > 9_999 && number < 100_000){
            int digit5 = number % 10;
            number = number / 10;
            int digit4 = number % 10;
            number /= 100;
            int digit2 = number % 10;
            int digit1 = number / 10;
            String resultString;
            if(digit1 == digit5 && digit2 == digit4){
                resultString = String.format("Числото %d е палиндрон.", originalNumber);
            }
            else{
                resultString = String.format("Числото %d не е палиндрон.", originalNumber);
            }
            System.out.println(resultString);
        }else{
            System.out.println("Не е 5-цифрено числото!");
        }
    }
}
