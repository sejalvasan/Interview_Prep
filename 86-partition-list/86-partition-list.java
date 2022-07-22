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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode small = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode large = dummy2;
        
        ListNode cur = head;
        
        while(cur!=null){
            if(cur.val<x){
                small.next = cur;
                small = small.next;
                cur = cur.next;
       small.next = null;
            }else{
                large.next=cur;
                large = large.next;
                   cur = cur.next;
       large.next = null;
            }
        }
        
        small.next = dummy2.next;
        dummy2.next = null;
        return dummy1.next;
    }
}