public class BinaryTree {

    Node root;

    public static BinaryTree createBinaryTree(int[] list) {
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < list.length; i++) {
            bt.add(list[i]);
        }

        return bt;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

}
