package ReverseLinkedListII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListIITest {
    void assertNoCycles(ListNode head) {
        List<ListNode> visited = new ArrayList<>();

        while (head != null && !visited.contains(head)) {
            visited.add(head);
            head = head.next;
        }

        assertNull(head); // I don't know how to make custom assertions atm
    }

    ListNode intArrayToListNodes(int[] intArray) {
        if (intArray.length == 0) {
            return new ListNode();
        }

        ListNode head = null;
        for (int i = intArray.length - 1; i >= 0; i--) {
//            System.out.println("Making node with value " + intArray[i]);
            head = new ListNode(intArray[i], head);
        }

        if (head == null) {
            return new ListNode();
        }

        return head;
    }

    @Test
    void testIntArrayToListHead() {
        ListNode head = intArrayToListNodes(new int[]{1,2,3,4,5});
        assertNoCycles(head);

        assertEquals(1, head.val);
        head = head.next;

        assertEquals(2, head.val);
        head = head.next;

        assertEquals(3, head.val);
        head = head.next;

        assertEquals(4, head.val);
        head = head.next;

        assertEquals(5, head.val);
        head = head.next;

        assertNull(head);
    }

//    @Test
//    void testReverseAll() {
//        ListNode head = intArrayToListNodes(new int[]{1,2,3,4,5,6,7});
//        assertEquals(head.toString(), "[1][2][3][4][5][6][7]");
//
//        ReverseLinkedListII solution = new ReverseLinkedListII();
//        head = solution.reverseList(head);
//        assertEquals(head.toString(), "[7][6][5][4][3][2][1]");
//    }

    @Test
    void testLeetcodeScenarioOne() {
        ListNode head = intArrayToListNodes(new int[]{1,2,3,4,5});
        ReverseLinkedListII solution = new ReverseLinkedListII();

        head = solution.reverseBetween(head, 2, 4);

        assertEquals("[1][4][3][2][5]", head.toString());
    }

    @Test
    void testLeetcodeScenarioTwo() {
//        StringBuilder sb = new StringBuilder();
//        sb.length();
//        sb.charAt;
        ListNode head = intArrayToListNodes(new int[]{1,2});
        ReverseLinkedListII solution = new ReverseLinkedListII();

        head = solution.reverseBetween(head, 1, 2);

        assertEquals("[2][1]", head.toString());
    }
}