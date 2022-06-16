// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}


 // } Driver Code Ends
//User function Template for Java

/*Structure of the Node of the BST is as
class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution
{
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		int count =0;
		
		while(true){
		    
		    while(root1!=null){
		        st1.push(root1);
		        root1 = root1.left;
		    }
		    
		        while(root2!=null){
		        st2.push(root2);
		        root2 = root2.right;
		    }
		    
		    if(st1.isEmpty() || st2.isEmpty())
		    break;
		    
		    Node top1 = st1.peek();
		    Node top2 = st2.peek();
		    
		    if(top1.data + top2.data ==x){
		        count++;
		        st1.pop();
		        root1 = top1.right;
		        st2.pop();
		        root2 = top2.left;
		    }else if(top1.data + top2.data <x){
		        st1.pop();
		        root1 = top1.right;
		    }else{
		        st2.pop();
		        root2 = top2.left;
		    }
		}
		return count;
	}
}

// { Driver Code Starts.

public class Main
{
    static FastIO f;

    // Function to Build Tree
    static Node buildTree(String str)
    {
    	// Corner Case
    	if(str.length() == 0 || str.charAt(0) == 'N')
    		return null;

    	// Creating array of strings from input
    	// string after spliting by space
    	String[] ip = str.split(" ");

    	// Create the root of the tree
    	Node root = new Node(Integer.parseInt(ip[0]));

    	// Push the root to the queue
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(root);

    	// Starting from the second element
	    int i = 1;
	    while (!queue.isEmpty() && i < ip.length) {

	        // Get and remove the front of the queue
	        Node currNode = queue.poll();

	        // Get the current node's value from the string
	        String currVal = ip[i];

	        // If the left child is not null
	        if (!currVal.equals("N")) {

	            // Create the left child for the current Node
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
    
    public static void main(String args[]) throws IOException
    {
        f = new FastIO();
        
        int t = f.nextInt();
        
        while(t-->0)
        {
            String tree1 = f.nextLine(), tree2 = f.nextLine();
            Node root1 = buildTree(tree1), root2 = buildTree(tree2);
            int x = f.nextInt();

            f.out(Solution.countPairs(root1, root2, x) + "\n");
        }
        
        f.flush();
    }
}

class FastIO
{
	BufferedReader br;
	PrintWriter bw, be;
	StringTokenizer st;

	public FastIO()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		be = new PrintWriter(System.err);
		st = new StringTokenizer("");
	}

	private void read() throws IOException
	{
		st = new StringTokenizer(br.readLine());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public String next() throws IOException
	{
		while(!st.hasMoreTokens())
			read();
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public float nextFloat() throws IOException
	{
		return Float.parseFloat(next());
	}

	public double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	public char nextChar() throws IOException
	{
		return next().charAt(0);
	}

	public void out(String s) throws IOException
	{
		bw.print(s);
	}

	public void flush() throws IOException
	{
		bw.flush();
		be.flush();
	}

	public void err(String s) throws IOException
	{
		be.print(s);
	}
}  // } Driver Code Ends