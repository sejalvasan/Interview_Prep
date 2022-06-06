/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2=0;
        ListNode c1 = headA;
        ListNode c2 = headB;
        
        while(c1 !=null){
            c1=c1.next;
            l1++;
        }
        
         while(c2!=null){
            c2=c2.next;
            l2++;
        }
        ListNode ptr =headB;
        ListNode ptr1 = headA;
        
        if(l2>l1){
            int diff = l2-l1;
            while(diff!=0){
                ptr = ptr.next;
                diff--;
            }
        }else if(l1>l2){
               int diff = l1-l2;
            while(diff!=0){
                ptr1 = ptr1.next;
                diff--;
            }
        }else{
            
        }
        
        while(ptr!=ptr1){
            ptr=ptr.next;
            ptr1=ptr1.next;
        }
        
        return ptr1;
    }
}