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

        // Create a new ListNode to hold the sum
        ListNode sumListNode = new ListNode(0);
        
        // Create a reference to the current node in the sum list
        ListNode currentSumNode = sumListNode;
        
        // Initialize the carry variable to 0
        int carry = 0;

        // Iterate through the lists until we reach the end of both lists
        while (list1 != null || list2 != null) {

            // If one of the lists is null, set the node value to 0
            int value1 = list1 == null ? 0 : list1.val;
            int value2 = list2 == null ? 0 : list2.val;
            
            // Calculate the sum of the current digits and the carry from the previous iteration
            int digitSum = value1 + value2 + carry;
            
            // Calculate the new carry for the next iteration
            carry = digitSum / 10;
            
            // Set the value of the current node in the sum list to the remainder of the digit sum
            currentSumNode.next = new ListNode(digitSum % 10);
            
            // Move to the next node in each of the lists and the sum list
            list1 = list1 == null ? null : list1.next;
            list2 = list2 == null ? null : list2.next;
            currentSumNode = currentSumNode.next;
        }

        // If there is a carry after the last iteration, add it to the sum list
        if (carry > 0) {
            currentSumNode.next = new ListNode(carry);
        }

        // Return the head of the sum list
        return sumListNode.next;
    }
}
