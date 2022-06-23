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
    int cameras;
    public int minCameraCover(TreeNode root) {
        cameras=0;
        //for root
        if(helper(root)==-1) cameras++;
        return cameras;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            //covered
            return 1;
        } 
         int lchild = helper(root.left);
        int rchild = helper(root.right);
        
        if(lchild==-1 ||rchild ==-1){
            cameras++;
            return 0;
        }
        
        if(lchild==0 || rchild ==0){
            //covered by a cam
            return 1;
        }
        
        //now both child are covered [1] or they have camera if their children needed it [0]
        //so i am the node which needs camera [-1]
        
        return -1;
    }
}