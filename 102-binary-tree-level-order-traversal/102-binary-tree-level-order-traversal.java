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
    public List<List<Integer>> levelOrder(TreeNode root) {
            
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
        return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
    List<Integer> list = new ArrayList<>();
            while(size-->0){
         TreeNode rem = q.remove();
            list.add(rem.val);
                
            if(rem.left!=null)
            q.add(rem.left);
            
            if(rem.right!=null)
            q.add(rem.right);
            }
            res.add(list);
        }
        return res;
    }
}