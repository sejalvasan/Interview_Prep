/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Codec {
    
    class Pair{
        TreeNode node;
        int state = 0;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append(".");
            sb.append(" ");
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        
        helper(root.left, sb);
        helper(root.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        
        String[]array = data.split(" ");
        int idx = 0;
        Stack<Pair> st = new Stack<>();
        Pair rootp = new Pair();
        rootp.node = new TreeNode(Integer.parseInt(array[0]));
        st.add(rootp);
        
        while(!st.isEmpty()){
            Pair p = st.peek();
            
            if(p.state==0){
                idx++;
                p.state++;
                
                if(!array[idx].equals(".")){
                    Pair lnode = new Pair();
                    lnode.node = new TreeNode(Integer.parseInt(array[idx]));
                    p.node.left = lnode.node;
                    
                    st.add(lnode);
                }
            }else if(p.state==1){
                  idx++;
                p.state++;
                
                if(!array[idx].equals(".")){
                    Pair rnode = new Pair();
                    rnode.node = new TreeNode(Integer.parseInt(array[idx]));
                    p.node.right = rnode.node;
                    
                    st.add(rnode);
            }
            }else{
                st.pop();
            }
        }
         return rootp.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));