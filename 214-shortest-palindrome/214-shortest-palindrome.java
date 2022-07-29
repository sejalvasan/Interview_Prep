class Solution {
    public String shortestPalindrome(String s) {
        
        String str = s+'#'+ new StringBuilder(s).reverse().toString();
        int lps=KMP(str);
        
        String ans = new StringBuilder(s.substring(lps)).reverse().toString() + s;
        
        return ans;
    }
    public int KMP(String s){
        int[]lps = new int[s.length()];
        
        int i=1, len =0;
        
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
        return lps[s.length()-1];
    }
}