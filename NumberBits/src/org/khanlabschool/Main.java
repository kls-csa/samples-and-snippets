package org.khanlabschool;

public class Main
{
    private static String zeroPad(String s, int length) {
        int neededZeros = length - s.length();
        if(neededZeros <= 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < neededZeros; i++) {
            sb.append("0");
        }

        sb.append(s);
        return sb.toString();
    }

    private static String chunkString(String s, int chunkSize) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            if(i % chunkSize == 0) {
                sb.append(" ");
            }
        }

        return sb.reverse().toString();
    }

    private static void printBits(int value) {
        String paddedBinary = zeroPad(Integer.toBinaryString(value), Integer.SIZE);
        System.out.format("%11d\t\t%12s\t\t%s\n", value, Integer.toUnsignedString(value), chunkString(paddedBinary, 4));
    }

    public static void main(String[] args) {
        printBits(1);   // = 2^0       = 0b0001
        printBits(2);   // = 2^1       = 0b0010
        printBits(3);   // = 2^1 + 1   = 0b0011
        printBits(4);   // = 2^2       = 0b0100
        printBits(9);   // = 2^3 + 1   = 0b1001
        printBits(20);  // = 2^4 + 2^2 = 0b0001_0100
        printBits(64);  // = 2^6       = 0b0100_0000
        printBits(255); // = 2^8 - 1   = 0b1111_1111

        printBits(Integer.MAX_VALUE);
        printBits(Integer.MIN_VALUE);

        printBits(-1);
        printBits(-2);

        printBits(Integer.MIN_VALUE + 1);
        printBits(Integer.MIN_VALUE + 255);
    }
}


