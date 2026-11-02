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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        while(queue.size()>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode n=queue.poll();
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null){
                    queue.offer(n.right);
                }
                if(i==size-1){
                    res.add(n.val);
                }
            }
            // res.add(queue.poll().val);
        }
        return res;
    }
}
