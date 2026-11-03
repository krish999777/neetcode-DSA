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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(queue.size()>0){
            int len=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode n=queue.poll();
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null){
                    queue.offer(n.right);
                }
                list.add(n.val);
            }
            res.add(list);
        }
        return res;
    }
}
