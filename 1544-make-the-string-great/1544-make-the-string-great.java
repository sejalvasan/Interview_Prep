class Solution {
    public String makeGood(String s) {
     Stack<Character> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            if(st.isEmpty()){
                st.add(s.charAt(i));
                continue;
            }
            else if(Math.abs(st.peek()-s.charAt(i))==32){
                st.pop();
            }
            else
                st.push(s.charAt(i));
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            ans =st.pop()+ans;
        }
        
        return ans;
    }
}