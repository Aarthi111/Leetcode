import java.util.*;

class Solution {
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

       
        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }

            else {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (
                            precedence.get(stack.peek()) > precedence.get(ch) ||
                            (precedence.get(stack.peek()).equals(precedence.get(ch)) && ch != '^')
                        )) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
