import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        System.out.println("#Infix to Postfix#");
        System.out.print("Masukkan ekspresi infix: ");
        
        String teksInfix = inputUser.nextLine();

        String teksPostfix = InfixToPostfixConverter.ubahKePostfix(teksInfix);

        System.out.println("\nHasil Konversi:");
        System.out.println("Infix   : " + teksInfix);
        System.out.println("Postfix : " + teksPostfix);

        inputUser.close();
    }
}