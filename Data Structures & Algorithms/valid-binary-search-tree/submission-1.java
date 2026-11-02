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
    boolean isValid=true;
    public boolean isValidBST(TreeNode root) {
        dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return isValid;
    }
    private void dfs(TreeNode root,int min,int max){
        if(root==null){
            return;
        }
        int val=root.val;
        if(val<=min||val>=max){
            isValid=false;
        }
        dfs(root.left,min,val);
        dfs(root.right,val,max);
    }
}
