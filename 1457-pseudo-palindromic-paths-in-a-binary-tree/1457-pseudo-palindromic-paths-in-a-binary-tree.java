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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[]arr = new int[10];
        
        helper(root, arr);
        return count;
    }
    
    public void helper(TreeNode root, int[]arr){
        if(root==null)
            return;
        
        arr[root.val]++;
        helper(root.left, arr);
        helper(root.right, arr);
        
        if(root.left==null && root.right==null){
            int flag = 0;
            for(int i =0;i<=9;i++){
                if(arr[i]%2!=0)
                    flag++;
            }
            
            if(flag==1 || flag ==0)
                count++;
        }
        
        arr[root.val]--;
    }
}