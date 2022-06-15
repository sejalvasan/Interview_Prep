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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        solve(ans,root,map);
        return ans;
    }
    
    public String solve(List<TreeNode> ans, TreeNode root, HashMap<String ,Integer> map){
        if(root==null){
            return "X";
        }
        
       String left= solve(ans,root.left,map);
        String right =solve(ans,root.right,map);
        String temp = root.val +" "+left+right;
        map.put(temp,map.getOrDefault(temp,0)+1);
        if(map.get(temp)==2)
            ans.add(root);
        
        return temp;
        
    }
}