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
    public ListNode mergeNodes(ListNode head) {
       
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){    
            int sum = 0;

            while(curr.val != 0){
                sum += curr.val;
                curr = curr.next;
            }

            prev.val = sum;
            prev.next = (curr.next == null) ? null : curr;
            prev = curr;
            curr = curr.next;
        } 

        return head;
    }
}