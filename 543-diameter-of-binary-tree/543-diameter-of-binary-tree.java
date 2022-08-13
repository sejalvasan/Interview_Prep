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
    public int diameterOfBinaryTree(TreeNode root) {
        int[]ans = dia(root);
        return ans[0]-1;
    }
    
    public int[]dia(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        
        int []lres = dia(root.left);
        int []rres = dia(root.right);
        
        int[]ans = new int[2];
        ans[0]=Math.max(Math.max(lres[0],rres[0]),lres[1]+rres[1]+1);
        ans[1]=Math.max(lres[1],rres[1])+1;
        
        return ans;
    }
}