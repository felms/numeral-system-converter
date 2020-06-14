package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        int base  = scanner.nextInt();
        String answer = "";

        switch(base) {
            case 2:
                answer = decimalToBinary(number);
                break;
            
            case 8:
                answer = decimalToOctal(number);
                break;

            case 16:
                answer = decimalToHexadecimal(number);
                break;

        }
        
        System.out.println(answer);
    }
    
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binNumber = new StringBuilder();
        
        while (decimalNumber > 0) {
            binNumber.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        
        return "0b" + (binNumber.length() > 0 ? binNumber.reverse().toString() : "0");
    }    
    
    public static String decimalToOctal(int decimalNumber) {
        StringBuilder octalNumber = new StringBuilder();
        
        while (decimalNumber > 0) {
            octalNumber.append(decimalNumber % 8);
            decimalNumber /= 8;
        }
        
        return "0" + (octalNumber.length() > 0 ? octalNumber.reverse().toString() : "0");
    }

    public static String decimalToHexadecimal(int decimalNumber) {
        StringBuilder hexadecimalNumber = new StringBuilder();
        String hexValues = "0123456789abcdef";
        
        while (decimalNumber > 0) {
            int digit = decimalNumber % 16;
            char hexDigit = hexValues.charAt(digit);
            hexadecimalNumber.append(hexDigit);
            decimalNumber /= 16;
        }
        
        return "0x" + (hexadecimalNumber.length() > 0 ? hexadecimalNumber.reverse().toString() : "0");
    }
}

