package problems;

import utils.ListNode;

public class SwappingNodesInLinkedList {
    public static void main(String[] args) {
        SwappingNodesInLinkedList obj = new SwappingNodesInLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = obj.swapNodes(head,1);
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        head = temp;

        while(temp!= null) {
            size++;
            temp = temp.next;
        }
        ListNode back = head;
        for(int i = 1; i<k; i++) {
            back = back.next;
        }
        ListNode front = head;
        for(int i = 1; i<size - k; i++) {
            front = front.next;
        }
        temp = back.next;
        back.next = front.next;
        front.next = temp;
        back = back.next;
        front = front.next;
        temp = back.next;
        back.next=front.next;
        front.next = temp;
        return head.next;
    }
}

/***
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */