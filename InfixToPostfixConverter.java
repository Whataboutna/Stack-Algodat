import java.util.Stack;

public class InfixToPostfixConverter {

    private static int Prioritas(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case ':':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String ubahKePostfix(String ekspresiInfix) {
        StringBuilder hasilPostfix = new StringBuilder();
        Stack<Character> penampungOperator = new Stack<>();

        for (int i = 0; i < ekspresiInfix.length(); i++) {
            char karakterSekarang = ekspresiInfix.charAt(i);

            if (karakterSekarang == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(karakterSekarang)) {
                hasilPostfix.append(karakterSekarang);
            }
            else if (karakterSekarang == '(') {
                penampungOperator.push(karakterSekarang);
            }
            else if (karakterSekarang == ')') {
                while (!penampungOperator.isEmpty() && penampungOperator.peek() != '(') {
                    hasilPostfix.append(penampungOperator.pop());
                }
                penampungOperator.pop();
            }
            else {
                while (!penampungOperator.isEmpty() && 
                       Prioritas(karakterSekarang) <= Prioritas(penampungOperator.peek())) {
                    hasilPostfix.append(penampungOperator.pop());
                }
                penampungOperator.push(karakterSekarang);
            }
        }
        while (!penampungOperator.isEmpty()) {
            if (penampungOperator.peek() == '(') {
                return "Ekspresi tidak valid (kurung tidak seimbang)";
            }
            hasilPostfix.append(penampungOperator.pop());
        }

        return hasilPostfix.toString();
    }
}