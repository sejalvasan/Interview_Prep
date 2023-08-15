//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        Node destination = makeParents(parent, root, target);
        return findDis(parent, destination);
    }
    
    public static Node makeParents(HashMap<Node, Node> parent, Node root, int target){
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node result = new Node(-1);
        
        while(!q.isEmpty()){
            Node node = q.remove();
            if(node.data == target) result = node;
            
            if(node.left!=null){
            parent.put(node.left, node);
            q.add(node.left);
            }
            
            if(node.right!=null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        
        return result;
    }
    
    public static int findDis(HashMap<Node, Node>parent, Node target){
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        
        q.add(target);
        set.add(target);
        int maxDis = 0;
        
        while(!q.isEmpty()){
            int flag = 0;
            int size = q.size();
            while(size-->0){
                Node node = q.remove();
                
                if(node.left!=null && set.contains(node.left)==false){
                    q.add(node.left);
                    set.add(node.left);
                    flag = 1;
                }
                
                if(node.right!=null && set.contains(node.right)==false){
                    q.add(node.right);
                    set.add(node.right);
                    flag = 1;
                }
                
                if(parent.get(node)!=null && set.contains(parent.get(node))==false){
                    q.add(parent.get(node));
                    set.add(parent.get(node));
                    flag = 1;
                }
            }
            if(flag == 1)
            maxDis++;
        }
        
        return maxDis;
    }
}