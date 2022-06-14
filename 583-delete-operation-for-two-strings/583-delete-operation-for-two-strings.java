class Solution {
    public int minDistance(String str1, String str2) {
      int m =str1.length();
	    int n =str2.length();
	    
	   int L[][] = new int[m + 1][n + 1];
        int i, j;

        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
 
                else if (str1.charAt(i - 1)
                         == str2.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
 
                else
                    L[i][j] = Math.max(L[i - 1][j],
                                       L[i][j - 1]);
            }
        }
        
	    int lcs = L[m][n];
        int del = m-lcs;
	    int ins = n-lcs;
	    int ans = del+ins;
	    return ans;
	} 
}