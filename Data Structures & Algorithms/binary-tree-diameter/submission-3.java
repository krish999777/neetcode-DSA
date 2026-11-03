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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestSubtree(root);
        return max;
    }
    private int longestSubtree(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=longestSubtree(root.left);
        int right=longestSubtree(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
