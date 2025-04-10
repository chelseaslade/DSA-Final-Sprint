package org.keyin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BST {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static Node root;

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) return new Node(value);
            if (value < root.value) root.left = insertRec(root.left, value);
            else root.right = insertRec(root.right, value);
            //Return current node
            return root;
        }

        public String toJson() {
            return nodeToJson(root);
        }

        private static String nodeToJson(Node node) {
            if (node == null) return "null";
            return String.format("{\"value\":%d,\"left\":%s,\"right\":%s}",
                    node.value,
                    nodeToJson(node.left),
                    nodeToJson(node.right));
        }


    //BST Methods
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
