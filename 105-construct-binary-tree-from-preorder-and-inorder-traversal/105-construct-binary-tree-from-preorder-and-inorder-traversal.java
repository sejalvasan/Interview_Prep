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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
       TreeNode root= construct(0,preorder.length-1,0,inorder.length-1,preorder,map);
        
        return root;
    }
    
    public static TreeNode construct(int prelo, int prehi, int inlo, int inhi, int[]preorder, HashMap<Integer, Integer> map){
        if(prelo>prehi || inlo>inhi)
            return null;
        
        TreeNode node = new TreeNode();
        node.val = preorder[prelo];
        
        int index = map.get(node.val);
        int count = index - inlo;
        
        node.left=construct(prelo+1,prelo+count, inlo,inlo+count,preorder,map);
        node.right=construct(prelo+1+count,prehi,index+1,inhi,preorder,map);
        
        return node;
    }
}