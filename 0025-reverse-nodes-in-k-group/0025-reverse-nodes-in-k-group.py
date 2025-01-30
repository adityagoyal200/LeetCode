# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        if head is None or k <= 1:
            return head

        temp = head
        prev = None

        while temp:
            k_node = self.find_kth(temp,k)

            if k_node is None:
                if prev:
                    prev.next = temp
                break
            else:
                next_node = k_node.next
                k_node.next = None
                new_head = self.reverse(temp)
                if temp == head:
                    head = new_head
                else :
                    prev.next = new_head
                
                prev = temp
                temp = next_node

        return head

    
    def find_kth(self,head,k):
        temp = head
        cnt = 1

        while temp and cnt < k:
            temp = temp.next
            cnt = cnt+1
        
        if cnt == k:
            return temp
        else :
            None
    
    def reverse(self,head):
        if head is None or head.next is None:
            return head

        temp = None
        curr = head

        while curr:
            temp2 = curr.next
            curr.next = temp
            temp = curr
            curr = temp2

        
        return temp
        