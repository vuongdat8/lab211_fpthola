package p11;

import java.util.Scanner;
import model.Binary;
import model.Decimal;
import model.Hexadecimal;
import Validate.Validate;

public class P11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();

        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        System.out.print("Choose the input base: ");

        int inputBaseChoice = scanner.nextInt();

        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        System.out.print("Choose the output base: ");

        int outputBaseChoice = scanner.nextInt();

        String inputValue = getInputValue(inputBaseChoice, validate);

        switch (inputBaseChoice) {
            case 1:
                Binary binary = new Binary();
                binary.setBinary(inputValue);

                switch (outputBaseChoice) {
                    case 1:
                        System.out.println("Binary to Binary: " + binary.getBinary());
                        break;
                    case 2:
                        System.out.println("Binary to Decimal: " + binary.convertToDecimal());
                        break;
                    case 3:
                        System.out.println("Binary to Hexadecimal: " + binary.convertToHexadecimal());
                        break;
                    default:
                        System.out.println("Invalid output base choice");
                        break;
                }
                break;
            case 2:
                Decimal decimal = new Decimal();
                decimal.setDecimal(Double.parseDouble(inputValue));

                switch (outputBaseChoice) {
                    case 1:
                        System.out.println("Decimal to Binary: " + decimal.convertToBinary());
                        break;
                    case 2:
                        System.out.println("Decimal to Decimal: " + decimal.getDecimal());
                        break;
                    case 3:
                        System.out.println("Decimal to Hexadecimal: " + decimal.convertToHexadecimal());
                        break;
                    default:
                        System.out.println("Invalid output base choice");
                        break;
                }
                break;
            case 3:
                Hexadecimal hexadecimal = new Hexadecimal();
                hexadecimal.setHexadecimal(inputValue);

                switch (outputBaseChoice) {
                    case 1:
                        System.out.println("Hexadecimal to Binary: " + hexadecimal.convertToBinary());
                        break;
                    case 2:
                        System.out.println("Hexadecimal to Decimal: " + hexadecimal.convertToDecimal());
                        break;
                    case 3:
                        System.out.println("Hexadecimal to Hexadecimal: " + hexadecimal.getHexadecimal());
                        break;
                    default:
                        System.out.println("Invalid output base choice");
                        break;
                }
                break;
            default:
                System.out.println("Invalid input base choice");
                break;
        }
    }

    private static String getInputValue(int inputBaseChoice, Validate validate) {
        switch (inputBaseChoice) {
            case 1:
                System.out.print("Enter binary number: ");
                return validate.checkInputBinary();
            case 2:
                System.out.print("Enter decimal number: ");
                return String.valueOf(validate.checkInputDecimal());
            case 3:
                System.out.print("Enter hexadecimal number: ");
                return validate.checkInputHexadecimal();
            default:
                return "";
        }
    }
}
