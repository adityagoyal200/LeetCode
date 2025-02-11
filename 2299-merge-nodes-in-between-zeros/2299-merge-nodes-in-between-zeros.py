class Solution:
    def mergeNodes(self, head):
        if not head or not head.next:
            return head

        prev = head
        curr = head.next

        while curr:
            curr_sum = 0
            while curr.val != 0:
                curr_sum += curr.val
                curr = curr.next

            prev.val = curr_sum
            prev.next = None if not curr.next else curr
            prev = curr
            curr = curr.next

        return head
