package LinkedListsPart2;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Definition for singly-linked list node with value and next pointer.
 */
class Node25 {
    int val;
    Node25 next;

    Node25(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListsPart2_StartingPointOfLoopInLL {

    /**
     * Function to detect the starting point of the loop in a linked list.
     */
    public Node25 detectCycle(Node25 head) {
        Node25 slow = head;
        Node25 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1
            fast = fast.next.next;      // move fast by 2

            if (slow == fast) {         // cycle detected
                slow = head;

                // find the starting point of the loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null; // no cycle
    }

    /**
     * Main method for user input and demonstration.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListsPart2_StartingPointOfLoopInLL solution = new LinkedListsPart2_StartingPointOfLoopInLL();

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        Node25 head = null, tail = null;
        HashMap<Integer, Node25> nodeMap = new HashMap<>();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            Node25 newNode = new Node25(val);
            nodeMap.put(i, newNode);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter index to connect tail to (for loop), or -1 for no loop: ");
        int loopIndex = scanner.nextInt();
        if (loopIndex >= 0 && loopIndex < n) {
            tail.next = nodeMap.get(loopIndex); // create loop
        }

        Node25 loopStart = solution.detectCycle(head);

        if (loopStart != null) {
            System.out.println("Cycle starts at node with value: " + loopStart.val);
        } else {
            System.out.println("No cycle detected in the linked list.");
        }

        scanner.close();
    }
}
