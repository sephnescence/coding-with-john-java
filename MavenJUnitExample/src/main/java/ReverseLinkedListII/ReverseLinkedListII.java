package ReverseLinkedListII;

import java.util.List;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode sentinal = new ListNode(-1, head);
        ListNode leftNodeParent = sentinal, leftNode, rightNode;

        for (int i = 1; i < left; i++) {
            leftNodeParent = leftNodeParent.next;
        }

        leftNode = leftNodeParent.next;

        rightNode = leftNode.next;
        for (int i = left + 1; i < right; i++) {
            rightNode = rightNode.next;
        }

        ListNode rightRemainder = rightNode.next;
        rightNode.next = null;

        ListNode prev, curr;
        prev = null;
        curr = leftNode;

        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        leftNodeParent.next = prev;
        leftNode.next = rightRemainder;

        return sentinal.next;
    }
}
