package LinkedListsPart2;

import java.util.*;

class Node23 {
    int val;
    Node23 next;
    Node23() {}
    Node23(int val) { this.val = val; }
    Node23(int val, Node23 next) { this.val = val; this.next = next; }
}

public class LinkedListsPart2_ReverseNodesInKGroup {

    // Function to reverse nodes in k-group
    public Node23 reverseKGroup(Node23 head, int k) {
        Node23 temp = head;
        Node23 prev = null;

        while (temp != null) {
            Node23 kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            Node23 nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse current k-group
            reverseList(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    // Helper function to get the k-th node from current node
    public Node23 getKthNode(Node23 temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    // Helper function to reverse a linked list
    public Node23 reverseList(Node23 head) {
        Node23 prev = null;
        Node23 curr = head;
        Node23 next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Helper to create a linked list from a list of integers
    public static Node23 createLinkedList(List<Integer> values) {
        Node23 dummy = new Node23(0);
        Node23 curr = dummy;
        for (int val : values) {
            curr.next = new Node23(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list
    public static void printLinkedList(Node23 head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main function with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input list
        System.out.println("Enter space-separated integers for the linked list:");
        String[] input = scanner.nextLine().split(" ");
        List<Integer> values = new ArrayList<>();
        for (String s : input) {
            values.add(Integer.parseInt(s));
        }

        // Read k
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Constraint check
        if (k <= 0) {
            System.out.println("Invalid input: k must be greater than 0");
            return;
        }

        Node23 head = createLinkedList(values);
        System.out.print("Original list: ");
        printLinkedList(head);

        LinkedListsPart2_ReverseNodesInKGroup sol = new LinkedListsPart2_ReverseNodesInKGroup();
        Node23 newHead = sol.reverseKGroup(head, k);

        System.out.print("List after reversing every " + k + " nodes: ");
        printLinkedList(newHead);
    }
}
