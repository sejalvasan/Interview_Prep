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
    
    public boolean isValidBST(TreeNode root) {
        //we can do this question by morris and use prev and curr for SC=O(1)
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
     
     public boolean isValidBST(TreeNode root, long min, long max){
         if(root==null) return true;
         
         if(root.val<=min || root.val>=max)
             return false;
         
         return isValidBST(root.left, min,root.val) && isValidBST(root.right,root.val,max);
     }
}

// class Solution {
//     public boolean isValidBST(TreeNode root) {
        
//         TreeNode prev = null;
//         TreeNode curr = root;
        
//         while(curr!=null){
//             if(curr.left==null){
//                 //print
//           if(prev!=null && prev.val>=curr.val) return false;

//                 prev = curr;
//                 curr= curr.right;
//             }else{
//                 TreeNode iop = curr.left;
                
//                 while(iop.right!=null && iop.right!=curr){
//                     iop=iop.right;
//                 }
                
//                 //not processed
//                 if(iop.right==null){
//                     iop.right = curr;
//                     curr=curr.left;
//                 }
                
//                 //processed
//                 if(iop.right==curr){
//                     //print
//             if(prev!=null && prev.val>=curr.val) return false;

//                 prev = curr;
                    
//                     iop.right=null;
//                     curr=curr.right;
//                 }
//             }
//         }
        
//             return true;
        
//     }
// }