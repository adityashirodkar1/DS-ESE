class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class binaryTree {
    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            if (root.data > data) {
                root.left = insert(root.left, data);
            }
            if (root.data <= data) {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    public static Node delete(Node root, int data) {
        if (root.data > data) {
            root.left = delete(root.left, data);
        } else if (root.data < data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node temp = inorderSuccessor(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 13);
        root = insert(root, 3);
        root = insert(root, 12);
        root = insert(root, 14);
        root = insert(root, 4);
        root = insert(root, 10);
        root = insert(root, 5);
        root = insert(root, 1);
        root = insert(root, 8);
        root = insert(root, 2);
        root = insert(root, 7);
        root = insert(root, 9);
        root = insert(root, 11);
        root = insert(root, 6);
        root = insert(root, 18);
        System.out.print("InOrder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("PreOrder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        postorder(root);
        System.out.println();
    }
}
