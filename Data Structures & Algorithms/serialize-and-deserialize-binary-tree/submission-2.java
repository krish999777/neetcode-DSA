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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        Deque<TreeNode> stack=new ArrayDeque<>();
        if(root==null){
            return "";
        }
        stack.push(root);
        while(stack.size()>0){
            TreeNode n=stack.pop();
            if(n.val==-1001){
                s.append(",null");
                continue;
            }
            s.append((n==root?"":",")+n.val);
            if(n.right!=null){
                stack.push(n.right);
            }else{
                stack.push(new TreeNode(-1001));
            }
            if(n.left!=null){
                stack.push(n.left);
            }else{
                stack.push(new TreeNode(-1001));
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return helper(new String[]{data});
    } 
    private TreeNode helper(String[] data){
        if(data[0].length()==0){
            return null;
        }
        int index=data[0].indexOf(',');
        String num=index==-1?data[0]:data[0].substring(0,index);
        data[0]=index==-1?"":data[0].substring(index+1);
        if(num.equals("null")){
            return null;
        }
        int n=Integer.parseInt(num);
        TreeNode node=new TreeNode(n);
        node.left=helper(data);
        node.right=helper(data);
        return node;
    }
}
