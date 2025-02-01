# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: Optional[ListNode]
        :type n: int
        :rtype: Optional[ListNode]
        """
        if head is None:
            return None
        
        fast = head
        slow = head

        for i in range(n):
            fast = fast.next
        
        if fast == None:
            return head.next
        
        while fast.next:
            fast = fast.next
            slow = slow.next
        

        slow.next = slow.next.next

        return head
        