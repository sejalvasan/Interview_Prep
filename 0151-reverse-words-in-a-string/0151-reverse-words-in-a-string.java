class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        
        String word = "";
        char[]p=s.toCharArray();
        
        for(int i =0;i<p.length;i++){
            
            while(i<p.length && p[i]==' '){
                i++;
            }
            
            while(i<p.length && p[i]!=' '){
                word+=p[i];
                i++;
            }
            
            st.push(word);
            word = "";
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            ans = ans+" "+st.pop();
        }
        
        return ans.trim();
    }
}