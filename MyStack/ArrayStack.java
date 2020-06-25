import java.util.EmptyStackException;

public class ArrayStack<E> implements MyStack<E> {

    // instance variables
    private E[] stack;
    private final int CAPACITY;
    private int top; // index position of the value at the top

    // constructor
    public ArrayStack(int cap) {
        // This line will cause a warning at compile time.
        // Ignore this.
        stack = (E[]) (new Object[cap]);
        CAPACITY = cap;
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean empty() {
        return size() == 0;
    }

    @Override
    public void push(E val) throws FullStackException {
        if (size() >= CAPACITY)
            throw new FullStackException("FULL");
        stack[++top] = val;

    }

    @Override
    public E peek() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        return stack[top];
    }

    @Override
    public E pop() throws EmptyStackException {
        E ans = peek();
        stack[top] = null; // Release Reference for garbage collection
        top--;
        return ans;
    }

    @Override
    public String toString() {
        String ans = "[";
        for (E x : stack) {
            if (x == null)
                break;
            ans += x + ",";
        }
        if (ans.length() > 1)
            ans = ans.substring(0, ans.length() - 1);
        ans += "]";
        return ans;
    }

    public void transferTo(ArrayStack<E> rhs) {
        while (!empty() && rhs.size() != rhs.CAPACITY) {
            rhs.push(pop());
        }
    }

    public static void main(String[] args) {
        MyStack<String> s = new ArrayStack<String>(5);
        System.out.println(s);
        System.out.println("size: " + s.size());
        System.out.println("empty: " + s.empty());
        s.push("a");
        System.out.println(s);
        System.out.println("size: " + s.size());
        s.push("b");
        System.out.println(s);
        System.out.println("size: " + s.size());
        System.out.println("Popping ... ");
        while (!s.empty()) {
            System.out.println(s.pop() + " " + s);
        }
        ArrayStack<Integer> A = new ArrayStack<Integer>(100);
        for (int i = 0; i < 100; i++) {
            A.push(i);
        }
        ArrayStack<Integer> B = new ArrayStack<Integer>(5);
        ArrayStack<Integer> C = new ArrayStack<Integer>(3);
        System.out.println("\nA: " + A + "\n" + "B: " + B + "\n" + "C: " + C);
        A.transferTo(B);
        B.transferTo(C);
        C.transferTo(A);
        B.transferTo(C);
        A.transferTo(B);
        B.transferTo(C);
        System.out.println("\nA: " + A + "\n" + "B: " + B + "\n" + "C: " + C);
    }

}
