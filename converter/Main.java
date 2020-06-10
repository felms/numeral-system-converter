package converter;

public class Main {
    public static void main(String[] args) {
        int number = 42;
        System.out.printf("%d is equal to %s\n", number, decimalToBinary(number));
    }
    
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binNumber = new StringBuilder();
        
        while (decimalNumber > 0) {
            binNumber.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        
        return "0b"+ binNumber.reverse().toString();
    }
}
