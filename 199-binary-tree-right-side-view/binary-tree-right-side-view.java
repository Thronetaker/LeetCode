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
        int val;
        TreeNode n;
        Pair(int val  , TreeNode t){
            this.val = val;
            this.n = t;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if( root == null ) return new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add( new Pair(0, root));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.val;
            TreeNode node = p.n;
            map.put( l, node.val);

            if( node.left!= null){
                q.add(new Pair( l+1, node.left));
            }

            if( node.right!= null){
                q.add(new Pair( l+1, node.right));
            }
        }

        return new ArrayList<>( map.values());
    }
}