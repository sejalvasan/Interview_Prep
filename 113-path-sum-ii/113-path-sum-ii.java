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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
    solve(root,ans,list,targetSum);
        return ans;
    }
    
    public void solve(TreeNode root ,List<List<Integer>> ans,List<Integer> list,int target){
        if(root ==null)
            return;
        
        if(root.left==null && root.right==null){
            if(target-root.val==0){
                List<Integer> base = new ArrayList<>(list);
                base.add(root.val);
                ans.add(base);
            }
            return;
        }
        
        list.add(root.val);
        
        solve(root.left, ans,list,target-root.val);
        solve(root.right,ans,list,target-root.val);
        
        
        list.remove(list.size()-1);
    }
}