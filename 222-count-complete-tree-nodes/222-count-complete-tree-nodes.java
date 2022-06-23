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
    public int countNodes(TreeNode root) {
        //brute  TC = O(N)
//         if(root==null)
//             return 0;
        
//         int ls = countNodes(root.left);
//         int rs = countNodes(root.right);
        
//         return ls+rs+1;
        
        
        //OPTIMISED TC = O(LOGN)^2
        
   if(root==null)
       return 0;
        
        int lh=0, rh=0;
        TreeNode node = root.left;
        
        while(node!=null){
            lh++;
            node = node.left;
        }
        
         node = root.right;
        
        while(node!=null){
            rh++;
            node = node.right;
        }
        
        
        if(lh==rh){
            int h = lh+1;
            return (1<<h)-1;
        }else
            return countNodes(root.left)+countNodes(root.right)+1;
    }
}