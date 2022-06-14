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
       helper(root);
        return max;
    }
    
     int helper(TreeNode node){
       
        if(node.left!=null && node.right!=null){
            int left = helper(node.left);
            int right = helper(node.right);
            int ldash = Math.max(0,left);
            int rdash = Math.max(0,right);
            
            max = Math.max(ldash+rdash+node.val,max);
            
            return Math.max(ldash,rdash)+node.val;
            
        }else if(node.left!=null){
            int left = helper(node.left);
            int ldash = Math.max(0,left);
           max = Math.max(ldash+node.val,max);

            return ldash+node.val;
            
        }else if(node.right!=null){
            int right = helper(node.right);
            int rdash = Math.max(0,right);
            max = Math.max(rdash+node.val,max);

            return rdash+node.val;
        }else{
            if(max<node.val) max = node.val;
        return node.val;
        }
    }
}