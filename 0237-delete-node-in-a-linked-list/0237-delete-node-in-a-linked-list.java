/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node==null)
            return;
        
        ListNode cur = node;
        cur.val = node.next.val;
        cur.next = cur.next.next;
    }
}