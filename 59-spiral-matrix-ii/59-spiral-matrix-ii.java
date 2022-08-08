class Solution {
    public int[][] generateMatrix(int n) {
        int totele = n*n;
        
        int[][]arr = new int[n][n];
        
       int minr=0, minc=0, maxc=n-1, maxr=n-1;
       int cnt =1;
        
        while(cnt<=totele){
            
            for(int i = minr,j=minc; j<=maxc && cnt<=totele;j++){
                arr[i][j]=cnt;
                cnt++;
            }
            
            minr++;
            
            for(int i = minr,j=maxc; i<=maxr && cnt<=totele;i++){
                arr[i][j]=cnt;
                cnt++;
            }
            
            maxc--;
            
            for(int i = maxr,j=maxc; j>=minc && cnt<=totele;j--){
                arr[i][j]=cnt;
                cnt++;
            }
            
            maxr--;
            
            for(int i = maxr,j=minc; i>=minr && cnt<=totele;i--){
                arr[i][j]=cnt;
                cnt++;
            }
            
            minc++;
            
        }
        
        return arr;
       
        
    }
}