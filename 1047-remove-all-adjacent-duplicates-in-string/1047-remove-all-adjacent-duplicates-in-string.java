class Solution {
    public String removeDuplicates(String s) {
     
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() || s.charAt(i)!=st.peek()){
                st.add(s.charAt(i));
            }else
                st.pop();
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            ans = st.pop()+ans;    
        }
        
        return ans;
    }
}