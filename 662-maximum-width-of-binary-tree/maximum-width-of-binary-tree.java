/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair{
        TreeNode node ;
        int idx;
        Pair(TreeNode node, int index) {
           this.node = node;
           this.idx = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        // If the tree is empty, return 0
        if (root == null)
            return 0;

        // Initialize maximum width as 0
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();

        q.add( new Pair( root , 0 ));

        while( !q.isEmpty()){
            int size = q.size();
            int first = 0 , last = 0;

            // Store the index of the first node at this level
            int minIndex = q.peek().idx;

            for(int i = 0 ; i< size ; i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int idx = p.idx - minIndex;
                if( i ==0 ) first = idx;
                if( i == size-1) last = idx;

                if(node.left != null ) {
                    q.add( new Pair( node.left , 2*idx +1));
                }
                if(node.right != null ) {
                    q.add( new Pair( node.right  , 2*idx +2));
                }

                
            }

            maxWidth = Math.max( maxWidth , last-first+1);

        }
        return maxWidth;
    }
}