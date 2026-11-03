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
    int count=0;
    public int goodNodes(TreeNode root) {
        countGood(root,root.val);
        return count;
    }
    private void countGood(TreeNode root, int max){
        if(root==null){
            return;
        }
        int val=root.val;
        if(val>=max){
            count++;
        }
        int thismax=Math.max(max,val);
        countGood(root.left,thismax);
        countGood(root.right,thismax);
    }
}
