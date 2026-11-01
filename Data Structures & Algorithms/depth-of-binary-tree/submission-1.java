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
    public int maxDepth(TreeNode root) {
        return maxDepth(root,1);
    }
    private int maxDepth(TreeNode root,int depth){
        if(root==null){
            return depth-1;
        }
        int d1=maxDepth(root.left,depth+1);
        int d2=maxDepth(root.right,depth+1);
        return Math.max(d1,d2);
    }
}
