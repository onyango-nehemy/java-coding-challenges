public class Question7_RotatedLinkedList {
    static class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }

    public class RotateList {

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        // Step 1: Count the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
    }
            // Step 2: Make the list circular
        tail.next = head;

        // Step 3: Calculate the effective rotation
        n = n % length;
        int stepsToNewHead = length - n;

        // Step 4: Find the new tail and new head
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;  // Break the cycle

        return newHead;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print("\"" + head.val + "\"" + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        int n = 2;

        System.out.print("Original list: ");
        printList(head);

        ListNode rotated = rotateRight(head, n);

        System.out.print("Rotated list:  ");
        printList(rotated);
    }
}