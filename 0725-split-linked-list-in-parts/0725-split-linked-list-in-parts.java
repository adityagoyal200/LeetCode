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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int partSize = len / k;
        int extra = len % k;

        ListNode[] result = new ListNode[k];
        temp = head;

        for (int i = 0; i < k && temp != null; i++) {
            result[i] = temp;
            int currentPartSize = partSize + (extra > 0 ? 1 : 0);
            extra--;

            for (int j = 1; j < currentPartSize; j++) {
                temp = temp.next;
            }

            ListNode nextPart = temp.next;
            temp.next = null;
            temp = nextPart;
        }

        return result;
    }
}
