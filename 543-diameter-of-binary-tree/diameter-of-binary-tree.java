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
    private int getD(TreeNode root , int maxi[]){
        if( root == null) return 0 ;

        int lh = getD(root.left , maxi);
        int rh = getD(root.right, maxi);
        maxi[0] = Math.max( maxi[0], lh+rh);  // here curr node is not considered in diameter 
        return 1 + Math.max( lh, rh);  //i t will  be considered for the parent of it 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = new int[1]; 
        //Primitives: copy of the value is passed → method changes don't affect original.
        //Arrays/Objects: copy of the reference is passed → modifying elements/fields affects original, but pointing the reference to a new object does not.
        getD(root, maxi);
        return maxi[0];
    }
}