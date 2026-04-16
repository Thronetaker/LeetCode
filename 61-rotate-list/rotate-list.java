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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode tail = head;

        //reach end
        while(tail.next!= null){
            tail = tail.next;
            len++;
        }
        //make it circular by joining tail to head
        tail.next = head;

        k = k % len;
        
        //check rotation remaining
        int step = len - k;
        ListNode newTail = head;
        for(int i = 0 ; i< step-1 ; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
        
    }
}