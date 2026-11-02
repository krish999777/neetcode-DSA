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
class NodeData{
    TreeNode n;
    int max;
    NodeData(TreeNode n,int max){
        this.n=n;
        this.max=max;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        Deque<NodeData> stack=new ArrayDeque<>();
        stack.push(new NodeData(root,root.val));
        int count=0;
        while(stack.size()>0){
            NodeData node=stack.pop();
            if(node.n.val>=node.max){
                count++;
            }
            int max=Math.max(node.max,node.n.val);
            if(node.n.left!=null){
                stack.push(new NodeData(
                    node.n.left,max
                ));
            }
            if(node.n.right!=null){
                stack.push(new NodeData(
                    node.n.right,max
                ));
            }
        }
        return count;
    }
}
