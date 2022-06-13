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
    int length;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
            
        length=0;
        helper(root,-1); //as we are calculating in terms of nodes but need edges
        return length-1;
    }
    
    
    public int helper(TreeNode root,int val){
        if(root ==null)
            return 0;
        
        
        int left = helper(root.left, root.val);
        int right = helper(root.right,root.val);
        
        length = Math.max(length, left+ right+1);
        
        if(val==root.val){
          return Math.max(left,right)+1; 
        }else
            return 0;
      
    }
}