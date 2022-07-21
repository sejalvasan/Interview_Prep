/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root,parent);
        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(target);
        vis.put(target, true);
        int curLevel =0;
        
        while(!q.isEmpty()){
            if(curLevel ==k)
                break;
            curLevel++;
            int size = q.size();
            while(size-->0){
                TreeNode cur = q.remove();
                
                if(cur.left!=null && vis.get(cur.left)==null){
                    q.add(cur.left);
                    vis.put(cur.left,true);
                }
                
                if(cur.right!=null && vis.get(cur.right)==null){
                    q.add(cur.right);
                    vis.put(cur.right,true);
                }
                
                if(parent.get(cur)!=null && vis.get(parent.get(cur))==null){
                    q.add(parent.get(cur));
                    vis.put(parent.get(cur),true);
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList();
        
        while(!q.isEmpty())
        {
         TreeNode cur = q.poll();
            ans.add(cur.val);
        }
        
        return ans;
    }
    
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            
            if(cur.left!=null){
                q.add(cur.left);
                map.put(cur.left,cur);
            }
            
            if(cur.right!=null){
                q.add(cur.right);
                map.put(cur.right,cur);
            }
        }
    }
}