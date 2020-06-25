public class BracketMatch {

    public static boolean isMatched(String s) {
        MyStack<Character> b = new NodeStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                b.push(ch);
            if (!b.empty()) {
                if (ch == ')' && b.peek() == '(')
                    b.pop();
                else if (ch == ']' && b.peek() == '[')
                    b.pop();
                else if (ch == '}' && b.peek() == '{')
                    b.pop();
		else if (ch == ')' || ch == ']' || ch == '}')
		    return false;
            }
        }
        return b.empty();
    }

    public static void main(String[] args) {
        System.out.println(
                "{ s = 2 * ( a[2] + 3); x = (1 + (2)) }: " + isMatched("{ s = 2 * ( a[2] + 3); x = (1 + (2)) }"));
        System.out.println("(([]): " + isMatched("(([])"));
        System.out.println(")(: " + isMatched(")("));
        System.out.println("{(}): " + isMatched("{(})"));
    }

}
