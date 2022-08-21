class Solution {
    public boolean backspaceCompare(String s, String t) {
     Stack<Character> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                st.push(s.charAt(i));
            }
            else{
               if(!st.isEmpty())
                st.pop();
            }
        }
        
        String s1 = "";
        while(!st.isEmpty()){
            s1+=st.pop();
        }
        
       st = new Stack<>();
           for(int i =0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                st.push(t.charAt(i));
            }
            else{
                if(!st.isEmpty())
                st.pop();
            }
        }
        
        String s2 = "";
        while(!st.isEmpty()){
            s2+=st.pop();
        }
        
        if(s1.equals(s2))
            return true;
        
        return false;
    }
}