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
    static int xKaL;
    static int xKaR;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        int remaining = n-xKaL-xKaR-1;
        int maxof3 = Math.max(remaining,Math.max(xKaL,xKaR));
        int rest = n- maxof3;
        
       if(maxof3>rest)
           return true;
        return false;
    }
    
    public static int size(TreeNode root, int x){
        if(root==null)
            return 0;
        
        int ls = size(root.left,x);
        int rs = size(root.right,x);
        
        if(root.val==x){
            xKaL = ls;
            xKaR = rs;
        }
        
        return ls+rs+1;
    }
}