package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        String base8 = decimalToBase8(number);
        
        System.out.println(base8.charAt(base8.length() - 1));
    }
    
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binNumber = new StringBuilder();
        
        while (decimalNumber > 0) {
            binNumber.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        
        return "0b"+ (binNumber.length() > 0 ? binNumber.reverse().toString() : "0");
    }    
    
    public static String decimalToBase8(int decimalNumber) {
        StringBuilder base8Number = new StringBuilder();
        
        while (decimalNumber > 0) {
            base8Number.append(decimalNumber % 8);
            decimalNumber /= 8;
        }
        
        return base8Number.length() > 0 ? base8Number.reverse().toString() : "0";
    }
}

