// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node newHead = reverse(head);
        int carry =0;
        
        Node cur=newHead, cur1=newHead, prev = null;
        
        while(cur!=null){
            int sum =0;
            if(prev ==null)
            {
                sum = cur.data+1;
            }else{
                sum = cur.data+carry;
            }
            carry = sum/10;
            cur.data = sum%10;
            prev = cur;
            cur = cur.next;
        }
        if(carry ==1){
            Node dummy = new Node(1);
            prev.next = dummy;
        }
     return reverse(cur1);
    
    }
    
    public static Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        
        while(cur!=null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            
        }
        return prev;
    }
}
