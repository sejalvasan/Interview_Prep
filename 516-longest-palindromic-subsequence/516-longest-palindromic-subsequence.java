class Solution {
    public int longestPalindromeSubseq(String S) {
        
       int m,n;
        m = n = S.length();
        String rev = ((new StringBuilder(S)).reverse()).toString();
        
         int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
 
                else if (S.charAt(i - 1)
                         == rev.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
 
                else
                    L[i][j] = Math.max(L[i - 1][j],
                                       L[i][j - 1]);
            }
        }
          return L[m][n];
    }
}