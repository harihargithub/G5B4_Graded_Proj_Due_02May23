package com.gl.bst_driver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    Node node;
    
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Helper method to traverse the BST in in-order and add nodes to a list
    public static void inOrderTraversal(Node node, List<Node> nodeList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, nodeList);
        nodeList.add(node);
        inOrderTraversal(node.right, nodeList);
    }

    // Method to convert a binary search tree to a skewed tree
    public static Node bstToSkewedTree(Node node) {
        if (node == null) {
            return null;
        }

        // Create a list of nodes from the binary search tree
        List<Node> nodeList = new ArrayList<>();
        inOrderTraversal(node, nodeList);

        // Re-link the nodes to form a skewed tree
        Node skewedRoot = nodeList.get(0);
        Node prevNode = skewedRoot;
        for (int i = 1; i < nodeList.size(); i++) {
            Node currNode = nodeList.get(i);
            prevNode.right = currNode;
            prevNode.left = null;
            prevNode = currNode;
        }
        prevNode.left = null;
        prevNode.right = null;

        return skewedRoot;
    }

    // Helper method to print the values of a skewed tree in ascending order
    public static void printSkewedTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printSkewedTree(node.right);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);

        // Convert the binary search tree to a skewed tree
        Node skewedRoot = bstToSkewedTree(tree.node);

        // Print the values of the skewed tree in ascending order
        printSkewedTree(skewedRoot);
    }
}


