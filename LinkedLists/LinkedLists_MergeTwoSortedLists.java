package LinkedLists;

import java.util.Scanner;

// Definition for singly-linked list
class Node3 {
    int val;
    Node3 next;
    Node3() {}
    Node3(int val) { this.val = val; }
    Node3(int val, Node3 next) { this.val = val; this.next = next; }
}

public class LinkedLists_MergeTwoSortedLists {
    // Function to merge two sorted linked lists
    public Node3 mergeTwoLists(Node3 list1, Node3 list2) {
        Node3 t1 = list1;
        Node3 t2 = list2;
        Node3 dummy = new Node3(-1);
        Node3 temp = dummy;

        // Merging both lists into one sorted list
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        // Attach remaining nodes from list1 or list2
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummy.next;
    }

    // Function to create a linked list from user input
    public static Node3 createList(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        if (n == 0) return null;

        System.out.println("Enter the elements in sorted order:");
        Node3 head = new Node3(scanner.nextInt());
        Node3 current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node3(scanner.nextInt());
            current = current.next;
        }
        return head;
    }

    // Function to print a linked list
    public static void printList(Node3 head) {
        Node3 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create first sorted linked list:");
        Node3 list1 = createList(scanner);

        System.out.println("Create second sorted linked list:");
        Node3 list2 = createList(scanner);

        LinkedLists_MergeTwoSortedLists solution = new LinkedLists_MergeTwoSortedLists();
        Node3 mergedList = solution.mergeTwoLists(list1, list2);

        System.out.println("Merged sorted linked list:");
        printList(mergedList);

        scanner.close();
    }
}
