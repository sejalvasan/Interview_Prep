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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null || head.next == null)
            return head;
        //left side
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode it = dummy;
        ListNode previt = null;
        
        for(int i =0;i<left;i++){
        previt = it;
            it = it.next;
        }
        
        ListNode itR = it;
        ListNode prevR = previt;
        
        for(int i = left;i<=right;i++){
            ListNode temp = itR.next;
            itR.next = prevR;
            prevR = itR;
            itR = temp;
        }
        
        previt.next = prevR;
        it.next = itR;
        
        return dummy.next;
    }
}