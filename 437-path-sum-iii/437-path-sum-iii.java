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
    
    //O(N^2)
//        int count =0;
//     public int pathSum(TreeNode root, int targetSum) {
//         travel1(root,targetSum);
//         return count;
//     }
    
//     public void travel1(TreeNode root, int targetSum){
//         if(root==null)
//             return;
        
//         travel2(root,0,targetSum);
        
//         travel1(root.left,targetSum);
//         travel1(root.right,targetSum);
//     }
    
//     public void travel2(TreeNode root, int csum, int targetSum){
//         if(root==null)
//             return;
        
//         if(csum+root.val == targetSum)
//             count++;
        
//         travel2(root.left,csum+root.val,targetSum);
//         travel2(root.right,csum+root.val,targetSum);
//     }
// }
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root ==null)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        helper(root, root.val, targetSum,map);
        return count;
    }
    
    public void helper(TreeNode node, int psum, int target, HashMap<Integer, Integer> map){
        
        if(map.containsKey(psum-target)){
            count+=map.get(psum-target);
        }
        
        if(map.containsKey(psum)){
            map.put(psum,map.get(psum)+1);
        }else{
            map.put(psum,1);
        }
        
        if(node.left!=null){
            helper(node.left, psum+node.left.val,target,map);
        }
        
        if(node.right!=null){
            helper(node.right, psum+node.right.val,target,map);
        }
        
        //call back
        if(map.get(psum)==1)
            map.remove(psum);
        else{
            map.put(psum,map.get(psum)-1);
        }
    }
}