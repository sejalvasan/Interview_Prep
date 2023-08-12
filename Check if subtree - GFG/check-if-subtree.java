//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String tt= br.readLine();
	            Node rootT = buildTree(tt);
	            
	            String s= br.readLine();
	            Node rootS = buildTree(s);
	           // printInorder(root);
	            
	            Solution tr=new Solution();
	            boolean st=tr.isSubtree(rootT, rootS);
	            if(st==true){
	                System.out.println("1");
	            }else{
	                System.out.println("0");
	            }
	        }
	}
}
// } Driver Code Ends


//User function Template for Java

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static boolean isSubtree(Node s, Node t) {
        // add code here.
        //n^2 solution
    //     if(S==null)
    //     return true;
        
    //     if(T==null)
    //     return false;
        
    //     if(isSame(T,S))
    //     return true;
        
    //     return (isSubtree(T.left,S) || isSubtree(T.right, S));
    // }
    
    // public static boolean isSame(Node T, Node S){
    //     if(S==null && T==null)
    //     return true;
        
    //     if(S==null || T==null)
    //     return false;
        
    //     return (S.data==T.data && isSame(T.left, S.left) && 
    //     isSame(T.right, S.right));
    
    StringBuilder sbs = new StringBuilder();
    preOrder(s, sbs);
    StringBuilder sbt = new StringBuilder();
    preOrder(t, sbt);
  

        if(sbs.toString().contains(sbt.toString())==false)
        return false;
       
        StringBuilder sss = new StringBuilder();
        inOrder(s, sss);
        StringBuilder sbb = new StringBuilder();
        inOrder(t, sbb);
       
      // inOrder(t, sbt);
         if(sss.toString().contains(sbb.toString())==false)
        return false;
      //return sss.toString().contains(sbb.toString());
       return true;
}

public static StringBuilder preOrder(Node root, StringBuilder sb){
    if(root==null)
        return sb.append("#");
    sb.append(root.data);
    preOrder(root.left, sb);
    preOrder(root.right, sb);
    return sb;
}
    
    public static StringBuilder inOrder(Node root, StringBuilder sb){
    if(root==null)
        return sb.append("#");
    inOrder(root.left, sb);
    sb.append(root.data);
    inOrder(root.right, sb);
    return sb;
}
    }