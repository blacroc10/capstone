// Linked Lists: use Floyd's algorithm to detect and remove a cycle.

// This node class represents a single node in the linked list.
class Node_SIT {
    int data;
    Node_SIT next;

    Node_SIT(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SIT_202 {
    public static void main(String[] args) {
        Node_SIT head = new Node_SIT(10);
        head.next = new Node_SIT(20);
        head.next.next = new Node_SIT(30);
        head.next.next.next = new Node_SIT(40);
        head.next.next.next.next = new Node_SIT(50);

        // Create cycle: node 50 points back to node 20.
        head.next.next.next.next.next = head.next;

        System.out.println("Cycle present before removal: " + detectCycle(head));

        removeCycle(head);

        System.out.println("Cycle present after removal: " + detectCycle(head));
        System.out.print("List after cycle removal: ");
        printList(head);
    }

    static boolean detectCycle(Node_SIT head) {
        Node_SIT slow = head;
        Node_SIT fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                   return true;
            }
        }
        return false;
    }

    static void removeCycle(Node_SIT head) {
        Node_SIT slow = head;
        Node_SIT fast = head;
        boolean hasCycle = false;

        // Step 1: Detect meeting point.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return;
        }

        // Step 2: Find the start of the cycle.
        slow = head;
        Node_SIT prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle.
        if (prev != null) {
            prev.next = null;
        } else {
            // Special case: cycle starts at head, find the last node in cycle.
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    static void printList(Node_SIT head) {
        Node_SIT current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
