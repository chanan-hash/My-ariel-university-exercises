import java.io.Serializable;

public class BinaryTree_1<T> implements Serializable {
// building binary tree class
// It works that we have a left and right subtrees

    private T _root;
    private BinaryTree_1 left;
    private BinaryTree_1 right;
    int modeCount = 0;

    // Empty binary tree
    public BinaryTree_1() {
        this(null);
    }

    // creating new binary tree
    public BinaryTree_1(T a) {
        this._root = a;
        this.left = null;
        this.right = null;
        this.modeCount = 0;
    }

    public BinaryTree_1<T> getLeft() {
        return this.left;
    }

    public BinaryTree_1<T> getRight() {
        return this.right;
    }

    public T get_root() {
        return this._root;
    }

    public boolean isEmpty() {
        if (get_root() == null) {
            return true;
        }
        return false;

        // return this.root == null
    }

    public int size() {// If the tree is empty we'll return 0
        int count = 0; // we need to declare it in the beginning, so we won;t have a lot of this variable in each calling

        if (isEmpty()) {
            return count;
        }
        // if we have only a root
        if ((get_root() != null) && (getLeft().isEmpty()) && (getRight().isEmpty())) {
            return 1;
        }

        // stop condition
        // counting left tree, if it is not null so we will add this to the size, it is recursive functuion, it stops when it is null
        if (!getLeft().isEmpty()) {
            count += getLeft().size(); // add each time 1, when it gets to the end
        }
        // the same with right tree
        if (!getRight().isEmpty()) {
            count += getLeft().size();
        }
        return count;
    }

    // if its right and left trees are null, it means it is not a sub tree
    public boolean isLeaf() {
        return (!this.isEmpty() && right.isEmpty() && getLeft() == null);
    }

    public void add(T a) {

    }


}
