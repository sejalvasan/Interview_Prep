// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{   
    public static Node reverseleft(Node head){
        Node prev = null;
        Node cur = head;
        while(cur!=null){
            Node next = cur.next;
            cur.next=prev;
            prev = cur;
            cur=next;
        }
        return prev;
    }
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node ==null ||k==1)return node;
        Node dummy = new Node(0);
         dummy.next=node;
        Node pre =dummy, nex=dummy, cur =dummy;
       
        int count =0;
        while(cur.next!=null){
            cur=cur.next;
            count++;
        }
        
        while(count>=k){
            
            cur = pre.next;
            nex=cur.next;
            for(int i =1;i<k;i++){
                cur.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex = cur.next;
            }
            pre=cur;
            count -=k;
        }
        cur.next =null;
      Node h=  reverseleft(nex);
        cur.next=h;
        return dummy.next;
    }
}

