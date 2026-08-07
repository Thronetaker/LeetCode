/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private void addInMid(Node head ){
        Node temp = head  ;
        while(temp != null){
            Node after = temp.next;
            Node copy = new Node(temp.val);

            //add
            copy.next = after;
            temp.next =  copy ;

            //for nexxt iteration ;
            temp = after;
        }
    }

    private void  setRandom(Node head ){
        Node temp = head;
        while( temp != null){
            Node copy = temp.next;

            if(temp.random != null){
                copy.random = temp.random.next;
            }else{
                copy.random = null;
            }
            temp = temp.next.next;
        }
    }

    private Node getNewHead(Node head){
        Node temp = head;
        Node dummyH = new Node(-1);
        Node res = dummyH;

        while( temp != null){
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyH.next;
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //copied node , add in middle of two node 
        addInMid(head);
        //set random value of copied node 
        setRandom(head);
        //make a list of copied node 
        return getNewHead(head);
    }
}