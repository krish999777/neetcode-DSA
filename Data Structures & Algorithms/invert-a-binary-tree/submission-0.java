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
        stack.push(root);
        while(stack.size()>0){
            TreeNode cur=stack.pop();
            TreeNode temp=null;
            if(cur.left!=null){
                stack.push(cur.left);
                temp=cur.left;
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
            cur.left=cur.right;
            cur.right=temp;
        }
        return root;
    
    }
}
