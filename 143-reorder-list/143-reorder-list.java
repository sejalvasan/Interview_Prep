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
    
    public ListNode reverse(ListNode node){
        if(node==null || node.next==null){
            return node;
        }
        ListNode prev=null,curr=node;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        mid=reverse(mid);
        slow=head;
        ListNode temp=new ListNode(-1);
        ListNode ans=temp;
        while(slow!=null && mid!=null){  
                if(slow!=null){
                    temp.next=slow;
                    temp=temp.next;
                    slow=slow.next;
                }
            if(mid!=null){
                temp.next=mid;
                temp=temp.next;
                mid=mid.next;
            }
        }
        if(slow!=null){
            temp.next=slow;
        }
        if(mid!=null){
            temp.next=mid;
        }
        head=ans.next;
    }
}