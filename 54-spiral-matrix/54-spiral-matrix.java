class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int maxc=c-1;
        int maxr=r-1;
        int minc=0;
        int minr=0;
        int cnt=0;
        int total = r*c;
        
        while(cnt<total){
            for(int i=minr,j=minc;j<=maxc && cnt<total;j++){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            minr++;
            
             for(int i=minr,j=maxc;i<=maxr && cnt<total;i++){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            maxc--;
            
             for(int i=maxr,j=maxc;j>=minc && cnt<total;j--){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            maxr--;
            
             for(int i=maxr,j=minc;i>=minr && cnt<total;i--){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            minc++;
        }   
     return spiral;
    }
}
