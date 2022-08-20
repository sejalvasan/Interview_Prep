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
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        
        while(cur!=null){
            ans*=2;
            ans+=cur.val;
            cur = cur.next;
        }    
        
        return ans;
    }
}