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
    public int goodNodes(TreeNode root) {
        return countGood(root,root.val);
    }
    private int countGood(TreeNode root, int max){
        if(root==null){
            return 0;
        }
        int val=root.val;
        int count=0;
        if(val>=max){
            count++;
        }
        int thismax=Math.max(max,val);
        count+=countGood(root.left,thismax);
        count+=countGood(root.right,thismax);
        return count;
    }
}
