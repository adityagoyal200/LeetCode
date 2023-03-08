/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;
        int carry = 0;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int temp = l1.val + l2.val;
            curr.next = new ListNode((temp + carry) % 10);
            carry = (temp + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return tmp.next;
    }
}
/*The function begins by creating a new ListNode called tmp with a value of 0, which will be the head of the new linked list that represents the sum. It also creates a new ListNode called curr which points to the same node as tmp, and an integer called carry which is initially set to 0.

The function then enters a loop that continues until there are no more digits to add in either l1 or l2. Inside the loop, the function checks if the current digit in either l1 or l2 is null. If it is, the function creates a new ListNode with a value of 0 to represent the missing digit.

The function then adds the corresponding digits in l1 and l2, along with the carry-over digit from the previous iteration (which is initially 0), and stores the result in a temporary variable temp. The function then calculates the new digit for the current position in the new linked list by taking the modulo 10 of temp + carry (i.e., the sum of the current digits and the carry-over digit) and creates a new ListNode with this value. The function then updates the carry-over digit by taking the integer division of temp + carry by 10 (i.e., the sum of the current digits and the carry-over digit divided by 10).

The function then moves to the next digits in l1 and l2, and the next node in the new linked list. It repeats this process until there are no more digits to add in either l1 or l2.

Finally, if there is still a carry-over digit remaining after the last digits in l1 and l2 have been added, the function adds a new ListNode with this value to the end of the new linked list.

The function then returns the next node of the tmp ListNode, which is the head of the new linked list that represents the sum of the input linked lists. */
