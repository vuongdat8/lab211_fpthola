package Validate;

import java.util.Scanner;

public class Validate {

    private final Scanner in = new Scanner(System.in);

    public String checkInputBinary() {
        while (true) {
            try {
                String binaryString = in.nextLine().trim();

                // Check if the input contains only 0s and 1s
                if (binaryString.matches("[01]+")) {
                    // Return the valid binary string
                    return binaryString;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be 0 or 1.");
                System.out.print("Enter again: ");
            }
        }
    }

    public double checkInputDecimal() {
        while (true) {
            try {
                String decimalString = in.nextLine().trim();

                // Check if the input contains only digits
                if (decimalString.matches("[0-9]+")) {
                    return Double.parseDouble(decimalString);
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Must enter 0-9.");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputHexadecimal() {
        while (true) {
            try {
                String hexString = in.nextLine().trim();

                // Check if the input is a valid hexadecimal number
                if (hexString.matches("[0-9A-Fa-f]+")) {
                    return hexString;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Must enter 0-9 or A-F.");
                System.out.print("Enter again: ");
            }
        }
    }
}
