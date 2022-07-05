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
    public ListNode rotateRight(ListNode head, int k) {
        
     int count = 1;
        ListNode cur = head;
        
        if(head ==null ||k==0)
            return head;
        
        while(cur.next!=null){
            cur = cur.next;
            count++;
        }
    
        k = k%count;
        
        cur.next = head;
        int len = count -k;
        
        while(len!=0){
            cur = cur.next;
            len --;
        }
        
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}