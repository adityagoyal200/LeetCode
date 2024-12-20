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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Stack<Integer> st = new Stack<>();
        int[] result = new int[list.size()];

        for(int i = list.size()-1; i >= 0; i--){
            while(!st.isEmpty() && list.get(st.peek()) <= list.get(i)){
                st.pop();
            }

            result[i] = (st.isEmpty() ? 0 : list.get(st.peek()));
            st.push(i);
        }

        return result;
    }
}