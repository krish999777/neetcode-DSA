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

class DepthNode{
    TreeNode n;
    int depth;
    DepthNode(TreeNode n,int depth){
        this.n=n;
        this.depth=depth;
    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max=0;
        Deque<DepthNode> stack=new ArrayDeque<>();
        stack.push(new DepthNode(root,1));
        while(stack.size()>0){
            DepthNode node=stack.pop();
            int depth=node.depth;
            max=Math.max(max,depth);
            if(node.n.left!=null){
                stack.push(new DepthNode(node.n.left,depth+1));
            }
            if(node.n.right!=null){
                stack.push(new DepthNode(node.n.right,depth+1));
            }
        }
        return max;
    }
}
