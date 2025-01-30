# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
        if head is None or head.next is None:
            return True

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        head2 = self.reverse(slow)

        slow = head
        while head2:
            if slow.val != head2.val:
                return False
            
            slow = slow.next
            head2 = head2.next

        return True
    

    def reverse(self,head):

        if head is None or head.next is None:
            return head
        

        temp = None
        curr = head
        
        while curr :
            tmp = curr.next
            curr.next = temp
            temp = curr
            curr = tmp
        
        return temp