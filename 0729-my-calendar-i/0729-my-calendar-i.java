class MyCalendar {

    class Node {
        int start, end, height;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.height = 1; // Initial height of a leaf node is 1
        }
    }

    private Node root;

    public MyCalendar() {
        root = null;
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }

        if (!canInsert(root, start, end)) {
            return false;
        }

        root = insert(root, start, end); // Insert the new booking and balance the tree
        return true;
    }

    private boolean canInsert(Node node, int start, int end) {
        if (end <= node.start) {
            return node.left == null ? true : canInsert(node.left, start, end);
        } else if (start >= node.end) {
            return node.right == null ? true : canInsert(node.right, start, end);
        }
        return false; // Overlap found
    }

    private Node insert(Node node, int start, int end) {
        // Standard BST insertion
        if (node == null) {
            return new Node(start, end);
        }

        if (end <= node.start) {
            node.left = insert(node.left, start, end);
        } else if (start >= node.end) {
            node.right = insert(node.right, start, end);
        }

        // Update height of this node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Balance the node if needed
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && start < node.left.start) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && start >= node.right.end) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && start >= node.left.end) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && start < node.right.start) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the (possibly balanced) node
    }

    // Utility functions for the AVL Tree

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */