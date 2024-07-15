import java.util.*;

public class InfixToPrefix {

    // Function to check if the character is an operand
    static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    // Function to check if the character is a digit
    static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    // Function to check if the character is an operator
    static boolean isOperator(char c) {
        return !isAlpha(c) && !isDigit(c);
    }

    // Function to get the priority of operators
    static int getPriority(char C) {
        switch (C) {
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Reverse the characters in the array between start and end
    static String reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    // Function to convert infix to postfix expression
    static String infixToPostfix(char[] infix1) {
        String infix = '(' + String.valueOf(infix1) + ')';
        int l = infix.length();
        Stack<Character> charStack = new Stack<Character>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < l; i++) {
            char c = infix.charAt(i);

            if (isAlpha(c) || isDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                charStack.push(c);
            } else if (c == ')') {
                while (charStack.peek() != '(') {
                    output.append(charStack.pop());
                }
                charStack.pop();
            } else {
                while (!charStack.isEmpty() && isOperator(charStack.peek()) && getPriority(c) <= getPriority(charStack.peek())) {
                    output.append(charStack.pop());
                }
                charStack.push(c);
            }
        }

        while (!charStack.isEmpty()) {
            output.append(charStack.pop());
        }

        return output.toString();
    }

    // Function to convert infix to prefix expression
    static String infixToPrefix(char[] infix) {
        int l = infix.length;

        // Reverse infix
        String reversedInfix = reverse(infix, 0, l - 1);
        infix = reversedInfix.toCharArray();

        // Replace '(' with ')' and vice versa
        for (int i = 0; i < l; i++) {
            if (infix[i] == '(') {
                infix[i] = ')';
            } else if (infix[i] == ')') {
                infix[i] = '(';
            }
        }

        // Get postfix expression
        String postfix = infixToPostfix(infix);

        // Reverse postfix to get prefix
        String prefix = reverse(postfix.toCharArray(), 0, postfix.length() - 1);

        return prefix;
    }

    // Driver code
    public static void main(String[] args) {
        String s = "x+y*z/w+u";
        System.out.println("Infix Expression: " + s);
        System.out.println("Prefix Expression: " + infixToPrefix(s.toCharArray()));
    }
}

