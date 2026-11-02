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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root==null){
            return -1;
        }
        int v1=dfs(root.left);
        if(k--==1){
            return root.val;
        }
        int v2=dfs(root.right);
        return v1==-1&&v2==-1?-1:v1!=-1?v1:v2;
    }
}
