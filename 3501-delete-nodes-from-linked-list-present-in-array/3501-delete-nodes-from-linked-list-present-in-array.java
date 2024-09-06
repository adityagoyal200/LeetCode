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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(nums == null || nums.length == 0){
            return head;
        }

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        while(set.contains(head.val)){
            head = head.next;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            while(curr != null && !set.contains(curr.val)){
                curr = curr.next;
                prev = prev.next;
            }
            if(curr != null){
                curr = curr.next;
                prev.next = curr;
            }
        }

        return head;
    }
}