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
// Definition for singly-linked list.


class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Step 1: Count total nodes
        int totalLength = 0;
        ListNode current = head;
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        // Step 2: Determine size of each part
        int partSize = totalLength / k;
        int extra = totalLength % k;

        current = head;
        for (int i = 0; i < k && current != null; i++) {
            result[i] = current;
            int currentPartSize = partSize + (extra-- > 0 ? 1 : 0);

            // Move current to the end of current part
            for (int j = 1; j < currentPartSize; j++) {
                current = current.next;
            }

            // Cut off the end of current part
            ListNode next = current.next;
            current.next = null;
            current = next;
        }

        return result;
    }
}
