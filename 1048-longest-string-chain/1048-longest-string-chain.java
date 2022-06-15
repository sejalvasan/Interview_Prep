class Solution {
    public int longestStrChain(String[] words) {
        //extension of LIS
        
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n = words.length;
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        int max =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(dp[i]<dp[j]+1 && check(words[i],words[j])){
                    dp[i]=dp[j]+1;
                }
                
                if(max<dp[i])
                    max=dp[i];
            }
        }
        return max;
    }
    
    public boolean check(String s1, String s2){
        // s1 will be greater
        if(s1.length()!=s2.length()+1)
            return false;
        
        int f =0;
        int l =0;
    
       while(f<s1.length()&& l<s2.length()){
           if(s1.charAt(f)==s2.charAt(l)){
               l++;
           }
           f++;
       }
        return l==s2.length();
        }
}