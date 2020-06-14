package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sourceRadix = Integer.parseInt(scanner.nextLine());
        String sourceNumber  = scanner.nextLine();
        int targetRadix = Integer.parseInt(scanner.nextLine());

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
        
        System.out.println(answer);
    }
    
}

