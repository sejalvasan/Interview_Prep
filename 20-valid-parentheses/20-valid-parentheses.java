class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        char[]p = s.toCharArray();
        
        for(int i =0;i<p.length;i++){
            
            if(p[i]=='('|| p[i]=='['|| p[i]=='{'){
                st.push(p[i]);
            }else{
                
                if(st.isEmpty())
                    return false;
                
                else if(!isMatching(p[i],st))
                    return false;
                
                else
                    st.pop();
            }
        }
        
        if(st.isEmpty())
            return true;
        
        return false;
    }
    
    public boolean isMatching(char s, Stack<Character> st){
        
        if(s==')'){
            if(st.peek()=='(')
                return true;
        }
        
        if(s==']'){
            if(st.peek()=='[')
                return true;
        }
        
        if(s=='}'){
            if(st.peek()=='{')
                return true;
        }
        
        return false;
    }
}