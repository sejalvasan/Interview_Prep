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
    int i=0; 
    public TreeNode recoverFromPreorder(String traversal) {
        //j for dash
        //k for value
        
      return  helper(traversal,0);
    }
    
    public TreeNode helper(String s, int depth){
        int j=0;
        
        while(i+j<s.length() && s.charAt(i+j)=='-'){
            j++;
        }
        
        if(j!=depth)
            return null;
        
        int k=0;
        
        while(i+j+k<s.length() && s.charAt(i+j+k)!='-')
            k++;
        
        int val = Integer.parseInt(s.substring(i+j,i+j+k)); //as substring mai last char not added
        
        i = i+j+k;
        
        TreeNode node = new TreeNode(val);
        
        node.left = helper(s, depth+1);
        node.right = helper(s, depth+1);
        
        return node;
    }
}