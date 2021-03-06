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


// class Solution {
//     class Pair{
//     boolean isBST = true;
//     long min =Long.MAX_VALUE;
//     long max = Long.MIN_VALUE;
// }
    
//     public boolean isValidBST(TreeNode root) {
//         //we can do this question by morris and use prev and curr for SC=O(1)
//     Pair ans = helper(root);
//         return ans.isBST;
//     }
    
//     public Pair helper(TreeNode root){
//         if(root == null){
//             return new Pair();
//         }
        
        
//         Pair lp = helper(root.left);
//         Pair rp = helper(root.right);
        
//         Pair mp = new Pair();
//         mp.min = Math.min(root.val,Math.min(lp.min,rp.min));
//         mp.max = Math.max(root.val,Math.max(lp.max,rp.max));
//         mp.isBST = root.val>lp.max && root.val<rp.min && lp.isBST && rp.isBST;
        
        
//         return mp;
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        TreeNode prev = null;
        TreeNode curr = root;
        
        while(curr!=null){
            if(curr.left==null){
                //print
          if(prev!=null && prev.val>=curr.val) return false;

                prev = curr;
                curr= curr.right;
            }else{
                TreeNode iop = curr.left;
                
                while(iop.right!=null && iop.right!=curr){
                    iop=iop.right;
                }
                
                //not processed
                if(iop.right==null){
                    iop.right = curr;
                    curr=curr.left;
                }
                
                //processed
                if(iop.right==curr){
                    //print
            if(prev!=null && prev.val>=curr.val) return false;

                prev = curr;
                    
                    iop.right=null;
                    curr=curr.right;
                }
            }
        }
        
            return true;
        
    }
}