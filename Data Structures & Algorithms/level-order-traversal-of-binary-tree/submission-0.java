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
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        queue.offer(root);
        while(queue.size()>0){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode n=queue.poll();
                list.add(n.val);
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null){
                    queue.offer(n.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
