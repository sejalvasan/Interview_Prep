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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
       TreeNode root= construct(0,inorder.length-1,0,postorder.length-1,postorder,map);
        
        return root; 
    }
    public static TreeNode construct(int inlo, int inhi, int postlo, int posthi,int[]postorder, HashMap<Integer,Integer> map){
        if(inlo>inhi || postlo>posthi)
            return null;
        TreeNode node = new TreeNode();
        node.val = postorder[posthi];
        int index = map.get(node.val);
        int count = inhi-index;
        
        node.left = construct(inlo,index-1, postlo,posthi-count-1,postorder,map);
        node.right = construct(index+1,inhi,posthi-count,posthi-1,postorder,map);
        
        return node;
    }
}