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
    public List<Integer> preorderTraversal(TreeNode root) {
//      List<Integer> al = new ArrayList<>();
//         helper(root, al);   
//         return al;
//     }    
//     public static void helper (TreeNode root, List<Integer> al) {   
//         if(root == null) return;
		
//         al.add(root.val);
//         helper(root.left, al);
//         helper(root.right, al);
       
//     }
        

     List<Integer> ans = new ArrayList<>();
//            if(root == null)
//             return ans;
//         Stack<TreeNode> st = new Stack<>();
//         st.add(root);
        
//         while(!st.isEmpty()){
//             TreeNode node = st.pop();
//             ans.add(node.val);
            
//             if(node.right!=null)
//                 st.add(node.right);
            
//             if(node.left!=null)
//                 st.add(node.left);
//         }
//         return ans;
        while(root!=null){
            if(root.left==null){
                ans.add(root.val);
                root=root.right;
            }else{
                TreeNode iop=root.left;
                
                while(iop.right!=null && iop.right!=root)
                    iop=iop.right;
                
                if(iop.right==null){
                    //not processed
                    ans.add(root.val);
                    iop.right = root; //making thread
                    root=root.left;
                }else{
                    //processed
                    iop.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}