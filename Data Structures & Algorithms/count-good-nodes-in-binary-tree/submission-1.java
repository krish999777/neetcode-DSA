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
        return countGoodNodes(root,root.val);
    }
    private int countGoodNodes(TreeNode node,int max){
        if(node==null){
            return 0;
        }
        int thisMax=Math.max(max,node.val);
        return (node.val>=max?1:0)
    +countGoodNodes(node.left,thisMax)
    +countGoodNodes(node.right,thisMax);
    }
}
