import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void containsNode() {
        int[] binaryTreeValues = {6, 4, 8, 3, 5, 7, 9};
        BinaryTree bt = BinaryTree.createBinaryTree(binaryTreeValues);
        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));

        assertFalse(bt.containsNode(1));
    }

    @Test
    public void deleteNodeFromTree() {
        int[] binaryTreeValues = {6, 4, 8, 3, 5, 7, 9};
        BinaryTree bt = BinaryTree.createBinaryTree(binaryTreeValues);

        assertTrue(bt.containsNode(9));
        bt.delete(9);
        assertFalse(bt.containsNode(9));
    }
}