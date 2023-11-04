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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        int len  = 1;

        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(tmp.next != null){
            len++;
            tmp = tmp.next;
        }

        
        ListNode pre = dummy;
        ListNode cur;
        ListNode nex;

        while(len >= k) {
            cur = pre.next;
            nex = cur.next;
        for(int i=1;i<k;i++) {
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = cur.next;
        }
            pre = cur;
            len -= k;
    }

        return dummy.next;
    }
}