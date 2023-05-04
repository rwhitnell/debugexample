package edu.guilford;

import java.util.Scanner;

public class DebugExample 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        // Get an integer from the user
        System.out.println("Enter an integer: ");
        int n = scan.nextInt();
        // Call the factorial method
        long result = -1;
        try {
            result = factorial(n);
        } catch (NegativeNumberException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Print the result
        System.out.println("The factorial of " + n + " is " + result);
    }

    // How do we fix the negative number entry problem?
    // try-catch block
    // conditional statement to catch the negative number and ask for new input
    // return a value that can't be a factorial, like -1

    // Build a recursive factorial method using long integers
    public static long factorial(long n) throws NegativeNumberException {
        // because we want someone else to deal with it
        if (n == 0) {
            // base case: smallest version of the problem
            // we have to know we will reach the base case
            // must know what the base case will return
            return 1;
        } else if (n < 0) {
            // throw an exception
            throw new NegativeNumberException();
        }
        else {
            // the method calls itself with a smaller version
            long result = 1;
            try {
                result = Math.multiplyExact(n, factorial(n-1));}
            catch (ArithmeticException e) {
                System.out.println("The factorial of " + n + " is too large to be represented by a long integer.");
            }
            return result;
        }
    }

    // Build a negative number exception class
    public static class NegativeNumberException extends Exception {
        public NegativeNumberException() {
            super("Negative numbers are not allowed.");
        }
    }

}
