package code;

import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String code;
        System.out.print("Въведи 4-цифрен код: ");
        code = input.next();
        if(code.length()==4)
        {
            int digit4 = ((int) code.charAt(1)) - '0';
            int digit3 = ((int) code.charAt(0)) - '0';
            int digit2 = ((int) code.charAt(3)) - '0';
            int digit1 = ((int) code.charAt(2)) - '0';
            if(digit1 == 7 || digit1 == 8 || digit1 == 9)
            {
                digit1 -= 7;
            }
            else{
                digit1 += 3;
            }
            if(digit2 == 7 || digit2 == 8 || digit2 == 9)
            {
                digit2 -= 7;
            }else{
                digit2 += 3;
            }
            if(digit3 == 7 || digit3 == 8 || digit3 == 9)
            {
                digit3 -= 7;
            }else{
                digit3 += 3;
            }
            if(digit4 == 7 || digit4 == 8 || digit4 == 9)
            {
                digit4 -= 7;
            }else{
                digit4 += 3;
            }
            int number = 1000 * digit1 + 100 * digit2 +
                    10 * digit3 + digit4;
            System.out.println("Original number: " + number);
        }
        else{
            System.out.println("Invalid input!");
        }
    }
}
