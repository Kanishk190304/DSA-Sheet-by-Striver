package ArraysPart3;

import java.util.*;

public class ArraysPart3_PowFunction{

    // Function to calculate x raised to the power n
    public double myPow(double x, int n){
        double ans = 1.0;
        long nn = n;

        // Handle negative exponent
        if(nn < 0){
            nn = -1 * nn;
        }

        // Fast exponentiation
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn / 2;
            }
        }

        // Invert result if exponent was negative
        if(n < 0){
            ans = 1.0 / ans;
        }
        return ans;
    }

    // Main function to handle user input and output
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base number: ");
        double x = scanner.nextDouble();

        System.out.println("Enter the exponent: ");
        int n = scanner.nextInt();

        ArraysPart3_PowFunction solution = new ArraysPart3_PowFunction();
        double result = solution.myPow(x, n);

        System.out.println(x + " raised to the power " + n + " is: " + result);

        scanner.close();
    }
}

