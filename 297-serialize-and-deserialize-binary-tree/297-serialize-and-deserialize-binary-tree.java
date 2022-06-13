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
        int state=0;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
     if(root==null)
         return "";
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        
        return sb.toString();
    }
    
    public void helper(TreeNode root,  StringBuilder sb){
        
        //pre order working
        if(root==null){
            sb.append(".");
         sb.append(" ");
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        
        String[]darray = data.split(" ");
        Stack<Pair> st =new Stack<>();
       Pair rootp=new Pair();
        rootp.node = new TreeNode(Integer.parseInt(darray[0]));
        st.add(rootp);
        
        int idx = 0;
        
        while(!st.isEmpty()){
            Pair p = st.peek();
            
            if(p.state==0){
                
              idx++;
                p.state++;
                
                if(!darray[idx].equals(".")){
                    Pair lp = new Pair();
                    lp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    p.node.left = lp.node;
                    
                    st.add(lp);
                }
                
            }else if(p.state==1){
                  idx++;
                p.state++;
                
                 if(!darray[idx].equals(".")){
                    Pair rp = new Pair();
                    rp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    p.node.right = rp.node;
                    
                    st.add(rp);
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