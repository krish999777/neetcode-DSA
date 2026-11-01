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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        if(root==null){
            return null;
        }
        stack.offer(root);
        while(stack.size()>0){
            TreeNode cur=stack.poll();
            TreeNode temp=null;
            if(cur.left!=null){
                stack.offer(cur.left);
                temp=cur.left;
            }
            if(cur.right!=null){
                stack.offer(cur.right);
            }
            cur.left=cur.right;
            cur.right=temp;
        }
        return root;
    }
}
