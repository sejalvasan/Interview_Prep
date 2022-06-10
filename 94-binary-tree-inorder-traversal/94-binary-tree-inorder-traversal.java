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
    public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         inorder(root,res);
//         return res;
//     }
    
//     public static void inorder(TreeNode root, List<Integer> res){
//         if(root==null)
//             return;
        
//         inorder(root.left,res);
//         res.add(root.val);
//         inorder(root.right,res);
//     }
        
        List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode node = root;
        // while(true){
        //   if(node!=null){
        //       st.add(node);
        //       node= node.left;
        //   }else{
        //       if(st.isEmpty())
        //           break;
        //       else{
        //           node = st.pop();
        //           res.add(node.val);
        //           node = node.right;
        //       }
        //   }
        // }
        // return res;
        
       while(root!=null){
           if(root.left==null){
               res.add(root.val);
               root = root.right;
           }else{
               TreeNode iop = root.left;
               
               while(iop.right!=null && iop.right!=root){
                   iop= iop.right;
               }
               //not processed
               if(iop.right==null){
                   iop.right = root;
                   root = root.left;
               }
               
               if(iop.right==root){
                   iop.right = null;
                   res.add(root.val);
                   root = root.right;
               }
           }
       }
        return res;
}
}