
//PriorityQueue(minHeap)
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode402 {
    int val;
    ListNode402 next;

    ListNode402(int val) {
        this.val = val;
    }
}

public class SIT_402 {
    public static void main(String[] args) {
        ListNode402 l1 = new ListNode402(1);
        l1.next = new ListNode402(4);
        l1.next.next = new ListNode402(5);
        ListNode402 l2 = new ListNode402(1);
        l2.next = new ListNode402(3);
        l2.next.next = new ListNode402(4);
        ListNode402 l3 = new ListNode402(2);
        l3.next = new ListNode402(6);

        ListNode402[] lists = { l1, l2, l3 };
        ListNode402 merged = mergeList(lists);

        System.out.println("Merged list in sorted order:");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }

        System.out.println();

    }

    static ListNode402 mergeList(ListNode402[] lists) {
        PriorityQueue<ListNode402> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode402 head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode402 dummy = new ListNode402(0);
        ListNode402 tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode402 smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

}

//Time complexity: O(N log k) where N is the total number of nodes across all lists and k is the number of lists.