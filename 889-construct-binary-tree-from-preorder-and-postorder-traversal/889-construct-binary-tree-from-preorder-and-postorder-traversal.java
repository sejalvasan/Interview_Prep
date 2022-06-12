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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
                int n = preorder.length;

        //to make searching easier in post
        for(int i=0;i<n;i++){
            map.put(postorder[i],i);
        }
        return construct(preorder,0,n-1,postorder,0,n-1,map);
    }
    
    public TreeNode construct(int[] preorder, int psi, int pei, int[] postorder,int ppsi, int ppei,   HashMap<Integer, Integer> map ){
        
        if(psi>pei || ppsi>ppei)
            return null;
        
      TreeNode root = new TreeNode( preorder[psi]);
        if(psi+1<=pei){
        int idx =map.get(preorder[psi+1]);
         int totEle = idx-ppsi+1;

        root.left = construct(preorder, psi+1, psi+totEle,postorder, ppsi, idx,map);
        root.right = construct(preorder,psi+1+totEle, pei,postorder, idx+1,ppei-1,map);
            }
                return root;
    }
}