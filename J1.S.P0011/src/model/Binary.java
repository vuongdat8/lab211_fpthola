package model;

import java.math.BigInteger;

public class Binary {

    private String binary;

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public BigInteger convertToDecimal() {
        BigInteger decimal = BigInteger.ZERO;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            if (binary.charAt(length - 1 - i) == '1') {
                decimal = decimal.add(BigInteger.valueOf(2).pow(i));
            }
        }
        return decimal;
    }

    public String convertToHexadecimal() {
        BigInteger decimal = convertToDecimal();
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();

        if (decimal.equals(BigInteger.ZERO)) {
            return "0";
        }

        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divAndRemainder = decimal.divideAndRemainder(BigInteger.valueOf(16));
            hex.insert(0, hexChars[divAndRemainder[1].intValue()]);
            decimal = divAndRemainder[0];
        }

        return hex.toString();
    }
}
