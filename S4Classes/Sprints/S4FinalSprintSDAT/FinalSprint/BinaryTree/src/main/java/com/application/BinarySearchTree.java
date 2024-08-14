package com.application;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Binary Search Tree (BST) data structure.
 */
public class BinarySearchTree {

    /**
     * The root node of the binary search tree.
     */
    @JsonProperty
    private Node root;


    /**
     * Inserts a value into the binary search tree.
     *
     * @param value the value to be inserted into the tree
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * A recursive helper method to insert a value into the binary search tree.
     *
     * @param root the root node of the tree
     * @param value the value to be inserted
     * @return the new root node of the tree
     */

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
}

/**
 * Represents a node in the binary search tree.
 */
    class Node {
        @JsonProperty
        int value;
        @JsonProperty
        Node left, right;

    /**
     * Constructs a new node with the given value.
     *
     * @param item the value to be stored in the node
     */

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

