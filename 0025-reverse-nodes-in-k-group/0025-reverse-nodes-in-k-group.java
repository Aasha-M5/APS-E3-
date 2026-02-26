class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to handle head changes
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {
            // Step 1: find the kth node
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // not enough nodes

            // Step 2: reverse k nodes
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: connect reversed group
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }

        return dummy.next;
    }
}
