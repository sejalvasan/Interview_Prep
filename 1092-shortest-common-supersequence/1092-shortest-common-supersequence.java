class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
   char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    
      int L[][] = new int[m+1][n+1];
 
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++)
    {
    for (int j=0; j<=n; j++)
    {
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
     }
    }
  
        String str = "";
        int row = m;
        int col = n;
        while (row>0 && col> 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                str = s1.charAt(row - 1) + str;
                row--;
                col--;
            } else if (L[row - 1][col] > L[row][col - 1]) {
                str = s1.charAt(row - 1) + str;
                row--;
            } else {
                str = s2.charAt(col - 1) + str;
                col--;
            }
        }
        
        while (row> 0) {
            str = s1.charAt(row - 1) + str;
            row--;
        }
        while (col> 0) {
            str = s2.charAt(col - 1) + str;
            col--;
        }
        return str;
    }
}