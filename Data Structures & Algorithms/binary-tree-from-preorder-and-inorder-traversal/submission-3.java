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
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<l;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,map,0,l,0);
    }
    private TreeNode build(int[] preorder,Map<Integer,Integer> map,int pres,int pree,int ins){
        if(pres-pree==0){
            return null;
        }
        int val=preorder[pres];
        TreeNode root=new TreeNode(val);
        int mid=map.get(val);
        root.left=build(preorder,map,pres+1,pres+mid-ins+1,ins);
        root.right=build(preorder,map,pres+mid-ins+1,pree,mid+1);
        return root;
    }
}
