class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode temp = head;
        len = findLen(temp);
        k = k % len;
        if (k == 0) {
            return head;
        }

        int count = 0;
    
        while (count != len - k - 1) {
            count++;
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        ListNode last = newHead;

        while (last.next != null) {
            last = last.next;
        }
        
        last.next = head;

        return newHead;
    }

    private int findLen(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
