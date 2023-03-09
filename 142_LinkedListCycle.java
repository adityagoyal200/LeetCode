/*Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
*/
import java.util.HashMap;
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

 class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp = head;
        int position = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(temp != null){
            position++;
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp, position);
            temp = temp.next;
        }
        return null;
    }
}
/*The code first checks if the head of the linked list is null or if there is only one node in the list. In either of these cases, there can't be a cycle, so the code returns null.
The code creates a HashMap object to store the nodes that have been visited. The key of each entry is a ListNode object and the value is the position of the node in the linked list.
The code then initializes a pointer called temp to the head of the linked list and a variable called position to 0.
The code then enters a while loop that continues as long as temp is not null.
Inside the loop, the code increments the position variable and checks if the hash map contains the current node (i.e., temp). If it does, then that means there is a cycle, so the code returns the current node.
If the hash map does not contain the current node, the code adds an entry to the hash map with the current node as the key and the current position as the value.
The code then sets the temp pointer to the next node in the list.
If the loop completes without finding a cycle, then the code returns null. */

/*can be more optimized using two pointers one slow and one fast
 * public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null){
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
}
*/

