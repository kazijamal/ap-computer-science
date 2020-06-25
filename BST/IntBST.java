import java.util.ArrayList;

public class IntBST {

    private TreeNode<Integer> root;
    private int size;

    private static class TreeNode<Integer> {
	private Integer value;
	private TreeNode<Integer> left, right;

	public TreeNode(Integer value, TreeNode<Integer> left, TreeNode<Integer> right) {
	    this.value = value;
	    this.left = left;
	    this.right = right;
	}

	public Integer getValue() {
	    return value;
	}

	public TreeNode<Integer> getLeft() {
	    return left;
	}

	public TreeNode<Integer> getRight() {
	    return right;
	}

	public void setLeft(TreeNode<Integer> x) {
	    left = x;
	}

	public void setRight(TreeNode<Integer> x) {
	    right = x;
	}

	public void setValue(Integer newValue) {
	    value = newValue;
	}

	public boolean isLeaf() {
	    return getLeft() == null && getRight() == null;
	}
    }

    public IntBST() {
	root = null;
	size = 0;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public int size() {
	return size;
    }

    public void add(Integer x) {
	root = add(x, root);
	size++;
    }

    private TreeNode<Integer> add(Integer x, TreeNode<Integer> rt) {
	if (rt == null)
	    rt = new TreeNode<Integer>(x, null, null);
	else if (x <= rt.getValue())
	    rt.setLeft(add(x, rt.getLeft()));
	else
	    rt.setRight(add(x, rt.getRight()));
	return rt;
    }

    public void preorder() {
	preorder(root);
	System.out.println();
    }

    private void preorder(TreeNode<Integer> rt) {
	if (rt != null) {
	    System.out.print(rt.getValue() + " ");
	    preorder(rt.getLeft());
	    preorder(rt.getRight());
	}
    }

    public void inorder() {
	inorder(root);
	System.out.println();
    }

    private void inorder(TreeNode<Integer> rt) {
	if (rt != null) {
	    inorder(rt.getLeft());
	    System.out.print(rt.getValue() + " ");
	    inorder(rt.getRight());
	}
    }

    public void postorder() {
	postorder(root);
	System.out.println();
    }

    private void postorder(TreeNode<Integer> rt) {
	if (rt != null) {
	    postorder(rt.getLeft());
	    postorder(rt.getRight());
	    System.out.print(rt.getValue() + " ");
	}
    }

    public void printSideways() {
	if (isEmpty())
	    System.out.println("empty");
	printSideways(root, 0);
    }

    private void printSideways(TreeNode<Integer> rt, int level) {
	if (rt != null) {

	    printSideways(rt.getRight(), level + 1);
	    for (int i = 0; i < level; i++)
		System.out.print("   ");
	    System.out.println(rt.getValue() + " ");
	    printSideways(rt.getLeft(), level + 1);
	}
    }

    // # edges on the longest path from root to leaf
    public int height() {
	return height(root);

    }

    private int height(TreeNode<Integer> rt) {
	if (rt == null || rt.isLeaf())
	    return 0;
	// at least 1 edge
	// if (rt.getLeft() == null)
	// return 1 + height(rt.getRight());
	// if (rt.getRight() == null)
	// return 1 + height(rt.getLeft());
	return 1 + Math.max(height(rt.getLeft()), height(rt.getRight()));
    }

    public boolean isBalanced() {
	return isBalanced(root);
    }

    private boolean isBalanced(TreeNode<Integer> rt) {
	if (rt == null)
	    return true;
	int a = rt.getLeft() == null ? 0 : 1 + height(rt.getLeft());
	int b = rt.getRight() == null ? 0 : 1 + height(rt.getRight());
	if (Math.abs(a - b) > 1)
	    return false;
	return isBalanced(rt.getLeft()) && isBalanced(rt.getRight());
    }

    public boolean isBalancedV2() {
	int n = size();
	if (n == 0)
	    return true;
	double log2 = Math.log(n) / Math.log(2);
	return height() == Math.floor(log2);
    }

    private TreeNode<Integer> minNode(TreeNode<Integer> rt) {
	while (rt != null && rt.getLeft() != null)
	    rt = rt.getLeft();
	return rt;
    }

    private TreeNode<Integer> maxNode(TreeNode<Integer> rt) {
	while (rt != null && rt.getRight() != null)
	    rt = rt.getRight();
	return rt;
    }

    public boolean remove(Integer x) {
	final int N = size();
	root = remove(x, root);
	return size() == N - 1;
    }

    // pre: at least 1 node and remove a leaf
    private TreeNode<Integer> remove(Integer x, TreeNode<Integer> rt) {
	if (rt == null)
	    return rt;
	if (rt.isLeaf() && rt.getValue() == x) {
	    rt = null;
	    size--;
	} else if (rt.getValue() == x) {
	    // no right subtree
	    if (rt.getRight() == null) {
		Integer max = maxNode(rt.getLeft()).getValue();
		rt.setValue(max);
		rt.setLeft(remove(max, rt.getLeft()));
	    } else {
		Integer min = minNode(rt.getRight()).getValue();
		rt.setValue(min);
		rt.setRight(remove(min, rt.getRight()));
	    }
	} else if (x > rt.getValue())
	    rt.setRight(remove(x, rt.getRight()));
	else
	    rt.setLeft(remove(x, rt.getLeft()));
	;
	return rt;
    }

    // Converts the BST to a circular doubly linked list and
    // returns the node at the front of the list. This node holds
    // the minimum value.
    public TreeNode<Integer> toList() {
	return toList(root);
    }

    private TreeNode<Integer> toList(TreeNode<Integer> rt) {
	if (rt.isLeaf()) {
	    rt.setLeft(rt);
	    rt.setRight(rt);
	    return rt;
	}
	TreeNode<Integer> left = rt.getLeft();
	TreeNode<Integer> right = rt.getRight();
	if (left != null) {
	    left.setRight(toList(left));
	    left.setLeft(rt);
	    left.setRight(rt);
	    rt.setLeft(left);
	}
	if (right != null) {
	    right.setRight(toList(right));
	    rt.setRight(right);
	    right.setLeft(rt);
	    right.setRight(left);
	}
	return rt;
    }

    public static void main(String args[]) {
	final Integer N = Integer.parseInt(args[0]);
	ArrayList<Integer> sequence = new ArrayList<Integer>();
	for (int i = 0; i < N; i++)
	    sequence.add((int) (Math.random() * 100));
	System.out.println("sequence: " + sequence);
	IntBST t = new IntBST();
	for (Integer x : sequence)
	    t.add(x);
	System.out.println("inorder: ");
	t.inorder();
	System.out.println("preorder: ");
	t.preorder();
	System.out.println("postorder: ");
	t.postorder();
	t.printSideways();

	System.out.println("height: " + t.height());
	System.out.println("is balanced: " + t.isBalanced());
	System.out.println("is balanced: " + t.isBalancedV2());
	if (!t.isEmpty()) {
	    System.out.println("Min value: " + t.minNode(t.root).getValue());
	    System.out.println("Max value: " + t.maxNode(t.root).getValue());
	}
	t.printSideways();
	sequence.add(0, -50);
	for (Integer x : sequence) {
	    System.out.println("remove: " + x);
	    t.remove(x);
	    t.printSideways();
	    System.out.println("size: " + t.size());
	}

    }

}
