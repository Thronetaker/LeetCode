/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        // Create a dummy node
        ListNode dummyNode = new ListNode(-1, null);

        // Temp pointer to build merged list
        ListNode temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller node
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyNode.next;
    }
    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head ;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return middle node
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head ;

        left = sortList(left);
        right = sortList(right);

        return mergeTwoSortedLinkedLists(left,right);

    }
}