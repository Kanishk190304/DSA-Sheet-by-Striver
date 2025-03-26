package LinkedLists;

import java.util.Scanner;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class LinkedLists_ReverseLL {
    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse current node's pointer
            prev = curr; // Move prev to current node
            curr = next; // Move to next node
        }
        return prev; // New head of reversed list
    }

    // Function to print the linked list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Empty list.");
            scanner.close();
            return;
        }

        System.out.println("Enter the values of the nodes:");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        LinkedLists_ReverseLL solution = new LinkedLists_ReverseLL();
        System.out.println("Original list:");
        solution.printList(head);

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList(head);
        System.out.println("Reversed list:");
        solution.printList(reversedHead);

        scanner.close();
    }
}
