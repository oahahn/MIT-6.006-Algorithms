public class BinaryTree {

    Node root;

    public static BinaryTree createBinaryTree(int[] binaryTreeElements) {
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < binaryTreeElements.length; i++) {
            bt.add(binaryTreeElements[i]);
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

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        } else if (value == current.value) {
            return true;
        } else if (value < current.value) {
            return containsNodeRecursive(current.left, value);
        }
        return containsNodeRecursive(current.right, value);
    }

    public void delete (int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            return deleteSingleNode(current);
        } else if (value < current.value) {
            return deleteRecursive(current.left, value);
        } else {
            return deleteRecursive(current.right, value);
        }
    }

    private Node deleteSingleNode(Node current) {
        boolean nodeHasNoChildren = (current.left == null && current.right == null);
        boolean nodeOnlyHasLeftChild = (current.right == null);
        boolean nodeOnlyHasRightChild = (current.left == null);

        if (nodeHasNoChildren) {
            return null;
        } else if (nodeOnlyHasLeftChild) {
            return current.left;
        } else if (nodeOnlyHasRightChild) {
            return current.right;
        } else {
            return deleteNodeWithTwoChildren(current);
        }
    }

    private Node deleteNodeWithTwoChildren(Node current) {
        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int findSmallestValue(Node root) {
        if (root.left == null) {
            return root.value;
        } else {
            return findSmallestValue(root.left);
        }
    }

}
