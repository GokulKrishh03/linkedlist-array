class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }
        
        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        LinkedListAddition solution = new LinkedListAddition();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("Result:");
        printList(result);

        System.out.println("\nAdditional test case:");
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);

        ListNode l4 = new ListNode(1);

        ListNode result2 = solution.addTwoNumbers(l3, l4);
        printList(result2);
    }
}