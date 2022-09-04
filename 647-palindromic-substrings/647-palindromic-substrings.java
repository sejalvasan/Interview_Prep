class Solution {
    public int countSubstrings(String S) {
        int N = S.length();
      boolean[][]dp = new boolean[N][N];
      int count =0;
      for(int gap =0;gap<N;gap++){
          for(int i=0,j=gap;j<N ;i++,j++){
              
              if(gap==0)
              dp[i][j]=true;
              else if(gap==1){
                  dp[i][j]=S.charAt(i)==S.charAt(j);
              }else{
                  if(S.charAt(i)==S.charAt(j) && dp[i+1][j-1]==true)
                  dp[i][j]=true;
              }
          if(dp[i][j]==true)
          count++;
       }
      }
      
      return count;
    }
}