class Solution {
    public int maximalSquare(char[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
       int [][]S = new int[n][m];
       int res=0;
        
      for(int i =0;i<n;i++){
       S[i][0] = mat[i][0]-'0';
       res =Math.max(res,S[i][0]);
        }
        
        for(int j=0;j<m;j++){
        S[0][j]=mat[0][j]-'0';
          res =Math.max(res,S[0][j]);
        }
        
        
        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                
                if(mat[i][j]-'0'==1)
                S[i][j]=Math.min(S[i][j-1],
                Math.min(S[i-1][j],S[i-1][j-1])) +1;
                
                else
                S[i][j]=0;
                
            if(S[i][j]>res)
                res=S[i][j];
            }
        }
        
        return res*res;
    }
}