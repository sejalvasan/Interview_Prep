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
   int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathUtil(root);
        return max;
    }
    
    public int maxPathUtil(TreeNode root){
        if(root==null)
            return 0;
        
        int left = maxPathUtil(root.left);
        int right = maxPathUtil(root.right);
        
        int ldash = Math.max(left,0);
        int rdash = Math.max(right,0);
        
        int leftToRight = ldash+rdash+root.val;
        if(max<leftToRight)
            max =leftToRight;
        
        return Math.max(ldash,rdash)+root.val;
        
    }
}