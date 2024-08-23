package model;

public class Decimal {

    private double decimal;

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public String convertToBinary() {
        long decimalAsLong = (long) decimal;
        StringBuilder binary = new StringBuilder();

        if (decimalAsLong == 0) {
            return "0";
        }

        while (decimalAsLong > 0) {
            long remainder = decimalAsLong % 2;
            binary.insert(0, remainder);
            decimalAsLong = decimalAsLong / 2;
        }

        return binary.toString();
    }

    public String convertToHexadecimal() {
        int decimalAsInt = (int) decimal;
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();

        if (decimalAsInt == 0) {
            return "0";
        }

        while (decimalAsInt > 0) {
            int remainder = decimalAsInt % 16;
            hex.insert(0, hexChars[remainder]);
            decimalAsInt = decimalAsInt / 16;
        }

        return hex.toString();
    }
}
