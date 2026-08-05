/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while( node !=null && node.next!= null){
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            if( node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
        
    }
}