package converter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        
        while (scanner.hasNext()) {
            inputs.add(scanner.nextLine());
        }

        if (inputs.size() != 3) {
            System.out.println("error");
            return;
        }
        
        String sRadix = inputs.get(0);
        String sourceNumber  = inputs.get(1);
        String tRadix = inputs.get(2);

        if (!validRadix(sRadix) || !validRadix(tRadix)) {
            System.out.println("error");
            return;
        }

        int sourceRadix = Integer.parseInt(sRadix);
        int targetRadix = Integer.parseInt(tRadix);

        String number = sourceNumber.contains(".") 
                        ? fractionalConverter(sourceRadix, sourceNumber, targetRadix)
                        : integerConverter(sourceRadix, sourceNumber, targetRadix) ;
        
        System.out.println(number);
    }

    public static String integerConverter(int sourceRadix, String sourceNumber, int targetRadix) {

        int decNumber;

        if (sourceRadix == 1) {
            decNumber = sourceNumber.length();
        } else {
            decNumber = Integer.parseInt(sourceNumber, sourceRadix);
        }

        String answer = "";

        if (targetRadix == 1) {
            StringBuilder n = new StringBuilder();
            for (int i = 0; i < decNumber; i++) {
                n.append("1");
            }

            answer = n.toString();
        } else {
            answer = Integer.toString(decNumber, targetRadix);
        }
        
        return answer;

    }

    public static String fractionalConverter(int sourceRadix, String sourceNumber, int targetRadix) {

        String result = "";
        
        if (sourceRadix == 10) {
            result = fracBaseTenToBaseN(sourceNumber, targetRadix);
        } else if (targetRadix == 10) {
            result = fracBaseNToBaseTen(sourceRadix, sourceNumber);
        } else {
            String r = fracBaseNToBaseTen(sourceRadix, sourceNumber);
            result = fracBaseTenToBaseN(r, targetRadix);
        }

        return result;
    }

    public static String fracBaseNToBaseTen(int sourceRadix, String sourceNumber) {

        String[] parts = sourceNumber.split("\\.");

        // Convert the integer part
        double integerPart = Integer.parseInt(parts[0], sourceRadix);

        // Convert the fractional part
        double decimalValue = 0.0;
        for (int i = 0; i < parts[1].length(); i++) {
            double parsedNumber = (double)Integer.parseInt(Character.toString(parts[1].charAt(i)), sourceRadix);

            decimalValue += parsedNumber / Math.pow(sourceRadix, i + 1);
        }

        return String.valueOf(integerPart + decimalValue);
    }

    public static String fracBaseTenToBaseN(String sourceNumber, int targetRadix) {
        
        String[] parts = sourceNumber.split("\\.");

        // Convert the integer part
        int decNumber = Integer.parseInt(parts[0]);
        String integerPart = Integer.toString(decNumber, targetRadix);
        
        if (targetRadix == 1) {
            StringBuilder n = new StringBuilder();
            for (int i = 0; i < decNumber; i++) {
                n.append("1");
            }
            return n.toString();
        }

        // Convert the fractional part
        String decimalValue = "";
        int digits = 5;
        double number = Double.parseDouble("0." + parts[1]);

        for (int i = 0; i < digits; i++) {
            double d = number * targetRadix;
            String doubleAsText = String.valueOf(d);
            int decPart = Integer.parseInt(doubleAsText.split("\\.")[0]);
            decimalValue += Integer.toString(decPart, targetRadix);
            number = d - decPart;
        }

        return integerPart + "." + decimalValue;
    }

    public static boolean validRadix(String radix) {
        return radix.matches("^([1-9]|[12][0-9]|3[0-6])$");
    }
    
}

