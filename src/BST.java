import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 *
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     *
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size() - 1));
    }

    /**
     * A function that searches for a value in the tree
     *
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        //
        return search(val, root);

    }

    public boolean search(int val, BSTNode n) {
        // Base Cases

        // If at end of tree false
        if (n == null) {
            return false;
        }
        // If found val true
        if (n.getVal() == val) {
            return true;
        }
        // If to the left in tree search left, else return right
        if (val > n.getVal()) {
            return search(val, n.getRight());

        } else {
            return search(val, n.getLeft());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */

    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> tree = new ArrayList<BSTNode>();

        getInorder(tree, root);

        return tree;
    }

    public void getInorder(ArrayList<BSTNode> a, BSTNode n) {
        // If after a leaf return
        if (n == null) {
            return;
        }
        // recurse left add root recurse right
        getInorder(a, n.getLeft());
        a.add(n);
        getInorder(a, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> tree = new ArrayList<BSTNode>();

        getPreorder(tree, root);

        return tree;
    }

    public void getPreorder(ArrayList<BSTNode> a, BSTNode n) {
        if (n == null) {
            return;
        }
        //  Add root recurse left recurse right
        a.add(n);
        getPreorder(a, n.getLeft());
        getPreorder(a, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> tree = new ArrayList<BSTNode>();

        getPostorder(tree, root);

        return tree;

    }

    public void getPostorder(ArrayList<BSTNode> a, BSTNode n) {
        if (n == null) {
            return;
        }
        //   Recurse left recurse right add root
        getPostorder(a, n.getLeft());
        getPostorder(a, n.getRight());
        a.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     *
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insert(false, null, root, val);

    }

    public void insert(boolean isLeft, BSTNode parent, BSTNode n, int val) {
        if (n == null) {
            n = new BSTNode(val);
            if (isLeft) {
                parent.setLeft(n);
            } else {
                parent.setRight(n);
            }
        }
        if (n.getVal() == val) {
            return;
        }
        if (val > n.getVal()) {
            insert(false, n, n.getRight(), val);
            return;
        }
        insert(true, n, n.getLeft(), val);
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     *
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
