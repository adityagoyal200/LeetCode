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
        ListNode head2 = new ListNode(0);
        head2.next = head;
        
        ListNode front=head2;
        ListNode back=head2;
        for(int i=0;i<=n;i++){
            front = front.next;
        }
        while(front!=null){
            back=back.next;
            front=front.next;
        }
        
        back.next = back.next.next;
        return head2.next;
    }
}