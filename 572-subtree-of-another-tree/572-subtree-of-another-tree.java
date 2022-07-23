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
StringBuilder sbs = new StringBuilder(",");
preOrder(s, sbs);
StringBuilder sbt = new StringBuilder(",");
preOrder(t, sbt);

    return sbs.toString().contains(sbt.toString());
}

public StringBuilder preOrder(TreeNode root, StringBuilder sb){
    if(root==null)
        return sb.append("#,");
    sb.append(root.val).append(",");
    preOrder(root.left, sb);
    preOrder(root.right, sb);
    return sb;
}
    }