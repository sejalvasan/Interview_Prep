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
    //public boolean isSubtree(TreeNode s, TreeNode subRoot) {
   public boolean isSubtree(TreeNode s, TreeNode t) {
       
  StringBuilder sbs = new StringBuilder();
    preOrder(s, sbs);
    StringBuilder sbt = new StringBuilder();
    preOrder(t, sbt);
  

        if(sbs.toString().contains(sbt.toString())==false)
        return false;
       
        StringBuilder sss = new StringBuilder();
        inOrder(s, sss);
        StringBuilder sbb = new StringBuilder();
        inOrder(t, sbb);
       
      // inOrder(t, sbt);
         if(sss.toString().contains(sbb.toString())==false)
        return false;
      //return sss.toString().contains(sbb.toString());
       return true;
}

    public static StringBuilder preOrder(TreeNode root, StringBuilder sb){
        if(root==null)
            return sb.append("#");
        sb.append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
        return sb;
    }
    
    public static StringBuilder inOrder(TreeNode root, StringBuilder sb){
    if(root==null)
        return sb.append("#");
    inOrder(root.left, sb);
    sb.append(root.val);
    inOrder(root.right, sb);
    return sb;
}}