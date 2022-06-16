// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Is_Node__Present_In_BST {
    void insert(Node root, int key) {

        if (key < root.data) {
            if (root.left != null)
                insert(root.left, key);
            else
                root.left = new Node(key);
        } else if (key > root.data) {
            if (root.right != null)
                insert(root.right, key);
            else
                root.right = new Node(key);
        }
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Is_Node__Present_In_BST obj = new Is_Node__Present_In_BST();
            int a1 = sc.nextInt();
            Node root = new Node(a1);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                obj.insert(root, a);
            }

            int s = sc.nextInt();
            BST g = new BST();
            if (g.search(root, s) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}// } Driver Code Ends


class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // base case
        if (root == null) return false;

        // if data at current node is equal to x, we return true.
        if (root.data == x) return true;

        // if data at the current node is less than given value, we call the
        // function recursively to search in right subtree.
        if (x > root.data) return search(root.right, x);
        // else we call the function recursively to search in left subtree
        else
            return search(root.left, x);
    }
}