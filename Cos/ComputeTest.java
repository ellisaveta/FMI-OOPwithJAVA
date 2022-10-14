

import java.util.Scanner;

public class ComputeTest {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        double epsilon;
        double x;

        do {
            System.out.print("Enter Accuracy in the interval (0, 1): ");
            epsilon = kbd.nextDouble();
        }while(epsilon <= 0 || epsilon >= 1); //validate epsilon
        
        System.out.print("Enter X [rads]: ");
        x = kbd.nextDouble();
        ComputeCosine compute = new ComputeCosine(epsilon);
        
        System.out.printf("Accurate cos(%.6f) = %.6f %n ", x, Math.cos(x));
        System.out.printf("Approx cos(%.6f) = %.6f %n ", x, compute.computeCos(x));
    }
}
