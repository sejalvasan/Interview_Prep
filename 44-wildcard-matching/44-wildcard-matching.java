class Solution {
    public boolean isMatch(String s, String p) {
        
               boolean[][]dp=new boolean[s.length()+1][p.length()+1];

            for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                
                if(i==dp.length-1&&j==dp[0].length-1){
                    dp[i][j]=true;
                    
                }else if(i==dp.length-1){
                    if(p.charAt(j)=='*'){
                        dp[i][j]=dp[i][j+1];
                    }else{
                        dp[i][j]=false;
                    }
                    
                }else if(j==dp[0].length-1){
                    
                        dp[i][j]=false;
                    
                }else{
                    if(p.charAt(j)=='?'){
                        dp[i][j]=dp[i+1][j+1];
                        
                    }else if(p.charAt(j)=='*'){
                        dp[i][j]=dp[i+1][j]||dp[i][j+1];
                        
                    }else if(p.charAt(j)==s.charAt(i)){
                        dp[i][j]=dp[i+1][j+1];
                        
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
    return dp[0][0];
    }
}