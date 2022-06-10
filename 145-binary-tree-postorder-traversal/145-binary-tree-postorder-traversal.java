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

class Pair{
    TreeNode node;
    int state;
    Pair(TreeNode node,int state){
        this.node = node;
        this.state = state;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //using 1 stack
//         TreeNode curr = root;
//         Stack<TreeNode> st = new Stack<>();
//         List<Integer> res = new ArrayList<>();
        
//         while(curr!=null || !st.isEmpty()){
//             if(curr!=null){
//                 st.add(curr);
//                 curr = curr.left;
//             }else{
//                 TreeNode temp = st.peek().right;
//                 if(temp==null){
//                     temp = st.pop();
//                     res.add(temp.val);
//                     while(!st.isEmpty() && temp==st.peek().right){
//                         temp = st.pop();
//                         res.add(temp.val);
//                     }
//                 }else{
//                     curr = temp;
//                 }
//             }
//         }
//         return res;
//     }
// }
        
     //using 2 stacks
//         Stack<TreeNode> st1 = new Stack<>();
//         Stack<TreeNode> st2 = new Stack<>();
//         List<Integer> res = new ArrayList<>();
        
//         if(root ==null)
//             return res;
//         st1.add(root);
        
//         while(!st1.isEmpty()){
//           TreeNode node = st1.pop();
//             st2.add(node);
            
//             if(node.left!=null)
//                 st1.add(node.left);
            
//             if(node.right!=null)
//                 st1.add(node.right);
            
//         }
        
//         while(!st2.isEmpty())
//             res.add(st2.pop().val);
        
//         return res;
        List<Integer> post = new ArrayList<>();
               Stack<Pair> st = new Stack<>();
               st.add(new Pair(root,1));
        if(root ==null)
            return post;
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state==1){
                top.state++;
                if(top.node.left!=null){
                    Pair lp = new Pair(top.node.left,1);
                    st.add(lp);
                }
            }else if(top.state==2){
                top.state++;
                if(top.node.right!=null){
                    Pair rp = new Pair(top.node.right,1);
                    st.add(rp);
                }
            }else{
                post.add(top.node.val);
                st.pop();
            }
        }
        return post;
    }
}