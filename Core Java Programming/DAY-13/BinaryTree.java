package com.Day13;

class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}
class BinaryTree {
    Node root;
    private int checkHeight(Node node) {
        if (node == null) {
            return 0; 
        }
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;      }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; 
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced() {
        return checkHeight(root) != -1;
    }
    public void insert(int data) {
        root = insertRec(root, data);
    }
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;    }	

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Insert nodes into the tree
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        if (tree.isBalanced()) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
        tree.insert(1);
        if (tree.isBalanced()) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }    } 	}

