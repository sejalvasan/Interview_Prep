/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode reverse(ListNode head){
        ListNode cur=head, prev=null,next=null;
        
        while(cur!=null){
            next = cur.next;
            cur.next=prev;
            prev = cur;
            cur = next;
        }
        return prev;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;
        
        ListNode sum = null;
        
        while(l1!=null || l2!=null || carry>0){
            int newVal = carry;
            
            if(l1!=null)
                newVal+=l1.val;
            if(l2!=null)
                newVal+=l2.val;
            
            carry = newVal/10;
            newVal = newVal%10;
            
            ListNode newNode = new ListNode(newVal);
            
            newNode.next = sum;
            sum = newNode;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
       return reverse(sum);
    }
}