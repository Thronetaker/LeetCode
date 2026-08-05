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
    public ListNode oddEvenList(ListNode head) {
        // Edge case: If list is empty or has only one node
        if (head == null || head.next == null) return head;
        int cnt = 1;
        ListNode oddH = null;
        ListNode evenH = null;
        ListNode oddT = null;
        ListNode evenT = null;
        ListNode curr = head;
        while( curr != null){
            if(cnt % 2 != 0 ){
                if( oddH == null) {
                    oddH = curr;
                    oddT = curr;
                }else{
                    oddT.next = curr;
                    oddT =  curr;
                }
            }else{
                if( evenH == null) {
                    evenH = curr;
                    evenT = curr;
                }else{
                    evenT.next = curr;
                    evenT =  curr;
                }
            }
            curr = curr.next;
            cnt++;
        }
         // If no even nodes found, return odd list
        if (evenH == null) return oddH;

        // If no odd nodes found, return even list
        if (oddH == null) return evenH;
        evenT.next = null;
        oddT.next = evenH;
        return oddH;
    }
}