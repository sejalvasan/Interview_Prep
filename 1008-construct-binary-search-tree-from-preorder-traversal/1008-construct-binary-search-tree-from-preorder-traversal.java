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
    public TreeNode bstFromPreorder(int[] pre) {
         
	    return tree(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
  
    int idx = 0;
    
    public TreeNode tree(int[]pre, int min, int max){
        if(pre.length==idx)
        return null;
        else if(pre[idx]>min && pre[idx]<max){
            TreeNode node = new TreeNode(pre[idx]);
            idx++;
            node.left = tree(pre, min, node.val);
            node.right = tree(pre, node.val, max);
            
            return node;
        }else{
            return null;
        }

    }
}