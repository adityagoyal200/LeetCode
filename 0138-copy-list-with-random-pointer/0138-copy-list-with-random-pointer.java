class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;

        // Step 1: Insert copied nodes in between the original nodes
        while (temp != null) {
            Node newCopy = new Node(temp.val);
            Node front = temp.next;
            temp.next = newCopy;
            newCopy.next = front;
            temp = front;
        }

        // Step 2: Create random links for the copied nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the copied list from the original list
        Node dummy = new Node(0);
        Node copy = dummy;
        temp = head;

        while (temp != null) {
            copy.next = temp.next;
            copy = copy.next;
            temp.next = copy.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
