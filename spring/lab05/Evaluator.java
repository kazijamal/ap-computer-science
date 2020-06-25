// Kazi Jamal and Sunan Tajwar Period 1

import java.util.Stack;

public class Evaluator {

  // precondition: exp is a String expression that is fully parenthesized (a set
  // of parentheses for each operator).
  // postcodition: returns a String [] of the tokens of exp.
  // ex. getTokens("(5-2.2)") -> ["(","5","-","2.2",")"]
  public static String[] getTokens(String exp) {
    exp = exp.replaceAll(" ", "");
    String[] tokens = exp.split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])");
    return tokens;
  }

  // precondition: receives an array of the tokens of an infix expression.
  // tokens must be one of the following:
  // (),+-*/%,sqrt
  // postcondition: evalutes the expression represented in expTokens
  // ex. evaluate(["(","5","-","2.2",")"]) returns 2.8
  // precondition: receives an array of the tokens of an infix expression.
  // tokens must be one of the following:
  // (),+-*/%,sqrt
  // postcondition: evalutes the expression represented in expTokens
  // ex. evaluate(["(","5","-","2.2",")"]) returns 2.8
  public static Double evaluate(String[] tokens) {
    Stack<String> operators = new Stack<String>();
    Stack<Double> operands = new Stack<Double>();
    String[] operandlist = { "+", "-", "*", "/", "%", "sqrt" };
    for (String x : tokens) {
      if (isFound(operandlist, x))
        operators.push(x);
      else if (!(x.equals("(") || x.equals(")")))
        operands.push(Double.parseDouble(x));
      else if (x.equals(")")) {
        if (operators.empty())
          return operands.pop();
        double a = operands.pop();
        String b = operators.pop();
        if (b.equals("+")) {
          double c = operands.pop();
          operands.push(c + a);
        } else if (b.equals("-")) {
          double c = operands.pop();
          operands.push(c - a);
        } else if (b.equals("*")) {
          double c = operands.pop();
          operands.push(c * a);
        } else if (b.equals("/")) {
          double c = operands.pop();
          operands.push(c / a);
        } else if (b.equals("%")) {
          double c = operands.pop();
          operands.push(c % a);
        } else if (b.equals("sqrt")) {
          operands.push(Math.sqrt(a));
        }
      }
    }
    return operands.pop();
  }

  public static boolean isFound(String[] x, String y) {
    for (String a : x) {
      if (a.equals(y))
        return true;
    }
    return false;
  }

  public static void main(String[] args) {

    String[] expressions = { "(2+3)", "(4 + (3 - 2))", "((5 *(10 + (32 - 8))/ 2.0))", "( sqrt  (16 * 16) )",
        "(( 25 % 3 ) + 9)" };
    Double[] expectedResults = { 5.0, 5.0, 85.0, 16.0, 10.0 };

    for (int i = 0; i < expressions.length; i++) {
      String[] tokens = getTokens(expressions[i]);
      Double ansObserved = evaluate(tokens);
      Double ansExpected = expectedResults[i];
      System.out.println(expressions[i] + " = " + evaluate(tokens));
      System.out.println("observed: " + ansObserved + " expected: " + ansExpected);
      System.out.println("correct? " + (ansObserved.equals(ansExpected)));
    }
  }

}
