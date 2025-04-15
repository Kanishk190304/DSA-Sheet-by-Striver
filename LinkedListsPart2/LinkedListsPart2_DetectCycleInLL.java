package LinkedListsPart2;

import java.util.Scanner;
import java.util.HashMap;

class Node22 {
    int val;
    Node22 next;
    Node22(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListsPart2_DetectCycleInLL {

    // Function to detect cycle using Floyd's Tortoise and Hare algorithm
    public boolean hasCycle(Node22 head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node22 slow = head;
        Node22 fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Main function to take input and create linked list with optional cycle
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListsPart2_DetectCycleInLL solution = new LinkedListsPart2_DetectCycleInLL();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Empty list, no cycle.");
            return;
        }

        System.out.println("Enter node values:");
        Node22 head = null;
        Node22 tail = null;
        HashMap<Integer, Node22> positionMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node22 newNode = new Node22(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            positionMap.put(i, newNode); // store node with index for optional cycle creation
        }

        System.out.print("Enter position to connect tail to (for cycle), or -1 for no cycle: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < n) {
            tail.next = positionMap.get(pos); // Create a cycle
        }

        boolean result = solution.hasCycle(head);

        if (result) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle detected in the linked list.");
        }
    }
}
