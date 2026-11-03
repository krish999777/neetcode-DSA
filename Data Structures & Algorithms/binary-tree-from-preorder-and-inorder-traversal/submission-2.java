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
        return build(preorder,inorder,0,l,0,l);
    }
    private TreeNode build(int[] preorder,int[] inorder,int pres,int pree,int ins,int ine){
        if(pres-pree==0){
            return null;
        }
        int val=preorder[pres];
        TreeNode root=new TreeNode(val);
        int mid;
        for(mid=ins;mid<ine;mid++){
            if(inorder[mid]==val){
                break;
            }
        }
        root.left=build(preorder,inorder,pres+1,pres+mid-ins+1,ins,mid);
        root.right=build(preorder,inorder,pres+mid-ins+1,pree,mid+1,ine);
        return root;
    }
}
