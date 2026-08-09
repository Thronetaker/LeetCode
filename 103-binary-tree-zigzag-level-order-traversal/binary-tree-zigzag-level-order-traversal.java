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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            // List<Integer> l = new ArrayList<>();
             Integer[] l = new Integer[size];

            for(int i = 0 ; i< size ; i++){
                TreeNode node = q.poll();

                // l.add(node.val);
                 // Determine index where this value should be stored
                int index = leftToRight ? i : size - 1 - i;
                l[index] = node.val;

                if( node.left != null) q.add(node.left);
                if( node.right != null) q.add(node.right);
                
                
            }
            leftToRight = !leftToRight;
            // res.add(l);
            res.add(Arrays.asList(l));
        }

        return res ;
    }
}