class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode front = head.next;
        ListNode prev = null;

        //1 2 3 4 5
        //2 1 4 3 5
        //2 1 

        while (curr != null && front != null) {
            if (curr == head) {
                curr.next = front.next;
                front.next = curr;
                head = front;
            } else {
                curr.next = front.next;
                front.next = curr;
                prev.next = front;
            }

            prev = curr;
            curr = curr.next;
            if (curr != null) front = curr.next;
        }

        return head;
    }
}
