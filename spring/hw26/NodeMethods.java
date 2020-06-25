public class NodeMethods {

    // precondition: p is either null or refers to a linkedlist of Node<Integer>
    // objects. Each value held within a node is nonnegative.
    // postcondition: returns the maximum value.
    public static int max(Node<Integer> p) {
        if (p == null) return 0;
        return Math.max(p.getValue(), max(p.getNext()));
    }
    
    public static void print(Node<Integer> p) {
        if (p == null) return;
        System.out.println(p.getValue());
        print(p.getNext());
    }

    public static void printReverse(Node<Integer> p) {
        if (p == null) return;
        printReverse(p.getNext());
        System.out.println(p.getValue());
    }

    public static int length(Node<Integer> p) {
        if (p == null) return 0;
        return 1 + length(p.getNext());
    }

    public static void main(String[] args) {
	int x = (int) (Math.random() * 100);
	int y = (int) (Math.random() * 100);
	int z = (int) (Math.random() * 100);
        Node<Integer> list = new Node<Integer>(x,new Node<Integer>(y,new Node<Integer>(z,null)));
        System.out.println("list: ");
        print(list);
        System.out.println("list reverse: ");
        printReverse(list);
        System.out.println("max: " + max(list));
        System.out.println("recursive max: " + maxR(list));
        System.out.println("length: " + length(list));
    }

}
