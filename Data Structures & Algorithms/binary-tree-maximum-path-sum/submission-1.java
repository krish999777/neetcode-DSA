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
    int max;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        calMax(root);
        return max;
    }
    private int calMax(TreeNode root){
         if(root==null){
            return 0;
         }
         int val=root.val;
         int leftSum=calMax(root.left);
         int rightSum=calMax(root.right);
         int sum=val;
         if(leftSum>0){
            sum+=leftSum;
         }
         if(rightSum>0){
            sum+=rightSum;
         }
         max=Math.max(max,sum);
         return Math.max(0,Math.max(leftSum,rightSum))+val;
    }
}
