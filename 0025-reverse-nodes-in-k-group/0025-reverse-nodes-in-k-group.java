class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kNode = findKth(temp, k);
            if (kNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            } else {
                ListNode nextNode = kNode.next;
                kNode.next = null;
                ListNode newHead = reverse(temp);
                if (temp == head) {
                    head = newHead;
                } else {
                    prevNode.next = newHead;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }

        return head;
    }

    private ListNode findKth(ListNode head, int k) {
        ListNode temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        return (count == k) ? temp : null;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
