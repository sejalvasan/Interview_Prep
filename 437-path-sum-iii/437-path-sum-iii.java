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
       int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        travel1(root,targetSum);
        return count;
    }
    
    public void travel1(TreeNode root, int targetSum){
        if(root==null)
            return;
        
        travel2(root,0,targetSum);
        
        travel1(root.left,targetSum);
        travel1(root.right,targetSum);
    }
    
    public void travel2(TreeNode root, int csum, int targetSum){
        if(root==null)
            return;
        
        if(csum+root.val == targetSum)
            count++;
        
        travel2(root.left,csum+root.val,targetSum);
        travel2(root.right,csum+root.val,targetSum);
    }
}