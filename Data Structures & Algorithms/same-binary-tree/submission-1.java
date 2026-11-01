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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1=new ArrayDeque<>();
        Deque<TreeNode> stack2=new ArrayDeque<>();
        if(p==null||q==null){
            if(p!=null||q!=null){
                return false;
            }
            return true;
        }
        stack1.push(p);
        stack2.push(q);
        while(stack1.size()>0&&stack2.size()>0){
            TreeNode n1=stack1.pop();
            TreeNode n2=stack2.pop();
            if(n1.val!=n2.val){
                return false;
            }
            if(n1.left!=null||n2.left!=null){
                if(n1.left==null||n2.left==null){
                    return false;
                }
                stack1.push(n1.left);
                stack2.push(n2.left);
            }
            if(n1.right!=null||n2.right!=null){
                if(n1.right==null||n2.right==null){
                    return false;
                }
                stack1.push(n1.right);
                stack2.push(n2.right);
            }
        }
        if(stack1.size()!=0||stack2.size()!=0){
            return false;
        }
        return true;
    }
}
