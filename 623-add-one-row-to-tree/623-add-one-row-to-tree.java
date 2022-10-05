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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1){
            TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
        }
        
        List<TreeNode> list = new ArrayList<>();
        //storing values before given depth so that we can attach new nodes to them
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(depth-->2){
            Queue<TreeNode> temp = new LinkedList<>();
            
            while(q.size()!=0){
            TreeNode rem = q.remove();
            if(rem.left != null)
                temp.add(rem.left);
            
            if(rem.right != null)
                temp.add(rem.right);
            }    
            q=temp;
        }
        
        // while(depth-->2){
        //     TreeNode rem = q.remove();
        //     if(rem.left!=null)
        //         q.add(rem.left);
        //     if(rem.right!=null)
        //         q.add(rem.right);
        // }
        
        
        while(q.size()>0){
            TreeNode top = q.remove();
            TreeNode temp = top.left;
            top.left = new TreeNode(val);
            top.left.left = temp;
            temp = top.right;
            top.right = new TreeNode(val);
            top.right.right = temp;
        }
        
        return root;
        
    }
}