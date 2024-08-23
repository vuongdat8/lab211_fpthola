package model;

public class Hexadecimal {

    private String hexadecimal;

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public String convertToBinary() {
        StringBuilder binary = new StringBuilder();
        char[] hexChars = hexadecimal.toUpperCase().toCharArray();

        for (char hexChar : hexChars) {
            int decimal = hexCharToDecimal(hexChar);
            String binarySegment = decimalToBinarySegment(decimal);
            binary.append(binarySegment);
        }

        // Remove leading zeros
        while (binary.length() > 1 && binary.charAt(0) == '0') {
            binary.deleteCharAt(0);
        }

        return binary.toString();
    }

    private int hexCharToDecimal(char hexChar) {
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0';
        } else if (hexChar >= 'A' && hexChar <= 'F') {
            return 10 + (hexChar - 'A');
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal character: " + hexChar);
        }
    }

    private String decimalToBinarySegment(int decimal) {
        StringBuilder binarySegment = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            binarySegment.insert(0, (decimal & 1));
            decimal >>= 1;
        }
        return binarySegment.toString();
    }

    public int convertToDecimal() {
        int decimal = 0;
        char[] hexChars = hexadecimal.toUpperCase().toCharArray();

        for (int i = 0; i < hexChars.length; i++) {
            int value = hexCharToDecimal(hexChars[i]);
            decimal = decimal * 16 + value;
        }
        return decimal;
    }
}
