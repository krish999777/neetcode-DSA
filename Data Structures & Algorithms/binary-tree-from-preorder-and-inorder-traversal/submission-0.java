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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int l=preorder.length;
        if(l==0){
            return null;
        }
        int num=preorder[0];
        TreeNode root=new TreeNode(num);
        int i;
        for(i=0;i<l;i++){
            if(inorder[i]==num){
                break;
            }
        }

        root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
        root.right=buildTree(Arrays.copyOfRange(preorder,i+1,l),Arrays.copyOfRange(inorder,i+1,l));

        return root; 
    }
}
