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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int start, int end){
        
        if(start>end){
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        
        List<TreeNode> list = new ArrayList<>();
        
        for(int i = start;i<=end;i++){
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1,end);
            
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode ans = new TreeNode(i);
                    ans.left = l;
                    ans.right = r;
                    list.add(ans);
                }
            }
        }
        
        return list;
    }
}