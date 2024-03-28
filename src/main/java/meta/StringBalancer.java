package meta;

import java.util.Stack;

public class StringBalancer {
    public static String balanceString(String input) {
        // if String is nul or empty
        StringBuilder balanced = new StringBuilder();
        int openBrackets = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                openBrackets++;
                balanced.append(ch);
            } else if (ch == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                    balanced.append(ch);
                }
            } else if (Character.isLetterOrDigit(ch)) {
                balanced.append(ch);
            }
        }

        // Remove the unmatched '(' from the end of the string
        for (int i = 0; i < openBrackets; i++) {
            balanced.deleteCharAt(balanced.lastIndexOf("("));
        }

        return balanced.toString();
    }

    public static String balanceString2(String input) {
        //
        Stack<Integer> stack = new Stack<>();
        char[] chars = input.toCharArray();// to iterate over each character
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    chars[i] = ' '; // Marking unbalanced ')' to be removed
                }
            }
        }

        // Remove unbalanced '(' by marking them
        while (!stack.isEmpty()) {
            chars[stack.pop()] = ' ';
        }

        // Construct the balanced string
        StringBuilder balanced = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') { // Skip the marked characters
                balanced.append(c);
            }
        }




        return balanced.toString();
    }
//
    public static void main(String[] args) {
        System.out.println(balanceString("(()")); // Outputs "()"
        System.out.println(balanceString("abc123")); // Outputs "abc123"
        System.out.println(balanceString(")abc("));
        // Outputs "abc"
        // Add more test cases as needed
        System.out.println(balanceString("a(b)c)"));
        System.out.println(balanceString2("(((a)"));
    }


}

