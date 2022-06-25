class Solution {
    public int longestValidParentheses(String S) {
            Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxL =0;
        
     for(int i =0;i<S.length();i++){
        char ch = S.charAt(i);
        
        if(ch=='(')
        st.push(i);
        else{
            if(!st.isEmpty())
            st.pop();
            
            if(!st.isEmpty())
            maxL = Math.max(maxL, i-st.peek());
            
            else
            st.push(i);
        }
     }
     return maxL;
}
}