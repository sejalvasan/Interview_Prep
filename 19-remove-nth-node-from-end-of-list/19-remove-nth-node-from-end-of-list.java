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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int num = 0;
        int count = countNodes(head);
        n = count - n;
        ListNode dummy = new ListNode(-1);
        
        ListNode cur = dummy;
        dummy.next = head;
        
        while(num<n){
            cur = cur.next;
            num++;
        }
        
        cur.next = cur.next.next;
        return dummy.next;
    }
    
    public int countNodes(ListNode head){
        ListNode cur = head;
        int cnt =0;
        while(cur!=null){
            cnt++;
            cur = cur.next;
        }
        
        return cnt;
    }
}