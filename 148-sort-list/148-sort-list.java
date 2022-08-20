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
    public ListNode sortList(ListNode head) {
        
   if(head==null || head.next ==null) return head;
        ListNode mid = middle(head);
        ListNode newHead = mid.next;
        mid.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newHead);
        
        return merged(l1,l2);
    }
    
    public ListNode merged(ListNode l1, ListNode l2){
        if(l1==null || l2==null) return l1!=null?l1:l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        while(l1!=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        
        while(l2!=null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
                return dummy.next;
    }
    
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
