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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        
        int first = -1;
        int last = -1;
        int miniDist = Integer.MAX_VALUE;
        int index = 1; 

        while (next != null) {

            if ((curr.val > prev.val && curr.val > next.val) 
            || (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    miniDist = Math.min(miniDist, index - last);
                }

                last = index;
            }
            
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{miniDist, last - first};
    }
}



