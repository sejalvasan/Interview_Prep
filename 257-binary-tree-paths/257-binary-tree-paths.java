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
    
    public List<String> binaryTreePaths(TreeNode root) {
       
        List<String> bt = new ArrayList<>();
        
        find(bt,root,"");
        
        return bt;
    }
    
    public void find(List<String> bt, TreeNode root, String path){
        if(root==null)
            return;
        
        if(root.left == null && root.right==null){
            path+=root.val;
            bt.add(path);
        }
        
        path+=root.val+"->";
        find(bt,root.left, path);
        find(bt,root.right, path);
    }
}