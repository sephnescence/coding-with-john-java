package ReverseLinkedListII;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        String returnString = "[" + val + "]";

        if (next != null) {
            returnString += next.toString();
        }

        return returnString;
    }
}
