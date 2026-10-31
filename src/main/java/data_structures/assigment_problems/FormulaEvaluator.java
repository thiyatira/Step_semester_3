package data_structures.assigment_problems;

import java.util.ArrayDeque;
import java.util.Deque;

// Evaluates arithmetic formulas in one scan using an operand stack and an operator stack.
public class FormulaEvaluator {

    public int evaluate(String expr) {
        if (expr == null || expr.isBlank()) {
            throw new IllegalArgumentException("expression must not be empty");
        }
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        int i = 0;
        while (i < expr.length()) {
            char ch = expr.charAt(i);
            if (ch == ' ') {
                i++;
            } else if (Character.isDigit(ch)) {
                int value = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    value = value * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                operands.push(value);
            } else if (ch == '(') {
                operators.push(ch);
                i++;
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    applyTop(operands, operators);
                }
                operators.pop();
                i++;
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    applyTop(operands, operators);
                }
                operators.push(ch);
                i++;
            } else {
                throw new IllegalArgumentException("Unexpected character: " + ch);
            }
        }
        while (!operators.isEmpty()) {
            applyTop(operands, operators);
        }
        return operands.pop();
    }

    private void applyTop(Deque<Integer> operands, Deque<Character> operators) {
        char op = operators.pop();
        int right = operands.pop();
        int left = operands.pop();
        switch (op) {
            case '+': operands.push(left + right); break;
            case '-': operands.push(left - right); break;
            case '*': operands.push(left * right); break;
            default:
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                operands.push(left / right);
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int precedence(char op) {
        return (op == '*' || op == '/') ? 2 : 1;
    }
}
