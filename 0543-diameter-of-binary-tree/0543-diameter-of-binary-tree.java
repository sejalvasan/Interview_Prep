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
    public int diameterOfBinaryTree(TreeNode root) {
        int[]ans = diameter(root);
        return ans[0]-1;
    }
    
    public int[]diameter(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        
        int[]lres = diameter(root.left);
        int[]rres = diameter(root.right);
        
        int[]myAns = new int[2];
        
        myAns[0]=Math.max(lres[1]+rres[1]+1, Math.max(lres[0],rres[0]));
        myAns[1]=Math.max(lres[1],rres[1])+1;
        
        return myAns;
    }
}
//      int[]ans = diameter(root);
//         return ans[0]-1;
//     }
    
//     public int[] diameter(TreeNode root){
//         if(root == null)
//             return new int[]{0,0};
        
//         int[]lres = diameter(root.left);
//         int[]rres = diameter(root.right);
        
//         int[]myAns = new int[2];
        
//         myAns[0]=Math.max(lres[1]+rres[1]+1,Math.max(lres[0],rres[0]));
//         myAns[1] = Math.max(lres[1],rres[1])+1;
        
//         return myAns;
//     }
// }