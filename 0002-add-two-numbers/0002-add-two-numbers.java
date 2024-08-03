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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        ListNode sumListNode = new ListNode(0);
        ListNode currentSumNode = sumListNode;
        int carry = 0;
        
        while (list1 != null || list2 != null) {
            int value1 = list1 == null ? 0 : list1.val;
            int value2 = list2 == null ? 0 : list2.val;
     
            int digitSum = value1 + value2 + carry;
            
            carry = digitSum / 10;
            
            currentSumNode.next = new ListNode(digitSum % 10);

            list1 = list1 == null ? null : list1.next;
            list2 = list2 == null ? null : list2.next;
            currentSumNode = currentSumNode.next;
        }

        if (carry > 0) {
            currentSumNode.next = new ListNode(carry);
        }

        return sumListNode.next;
    }
}