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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean checkBST(TreeNode root,int min,int max){
        if(root==null){
            return true;
        }
        int val=root.val;
        if(val<=min||val>=max){
            return false;
        }
        return checkBST(root.left,min,val)&&checkBST(root.right,val,max);
    }
}
