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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }
    private int height(TreeNode root){
        if(root==null){
            return -1;
        }
        int heightL=height(root.left)+1;
        int heightR=height(root.right)+1;
        res=Math.max(res,heightL+heightR);
        return Math.max(heightL,heightR);
    }
}
