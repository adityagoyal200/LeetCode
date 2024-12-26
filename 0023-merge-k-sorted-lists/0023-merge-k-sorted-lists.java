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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head: lists){
            if(head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            temp.next = tmp;
            temp = temp.next;
            if(tmp.next != null) pq.offer(tmp.next);
        }

        return dummy.next;
    }
}