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
        int count1 = 0;
        ListNode temp = headA;
        while(temp!=null){
            temp=temp.next;
            count1++;
        }
        int count2 = 0;
        ListNode temp2 = headB;
        while(temp2!=null){
            temp2=temp2.next;
            count2++;
        }
         if(count1 > count2){
            for(int i=0;i< count1-count2;i++){
                headA=headA.next;
            }
        }else{
            for(int i=0;i<count2-count1;i++){
                headB=headB.next;
            }
        }
        while(headA != headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}