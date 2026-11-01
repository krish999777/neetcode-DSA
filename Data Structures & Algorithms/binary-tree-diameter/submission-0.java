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
    private int[] height(TreeNode root){
        if(root==null){
            return new int[]{-1,-1};
        }
        int[] leftSub=height(root.left);
        int heightL=Math.max(leftSub[0],leftSub[1])+1;
        int[] rightSub=height(root.right);
        int heightR=Math.max(rightSub[0],rightSub[1])+1;
        res=Math.max(res,heightL+heightR);
        return new int[]{heightL,heightR};
    }
}
