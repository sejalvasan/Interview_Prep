class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i =0;i<m;i++){
            countSort(mat,i,0);
        }
        
        for(int j =1;j<n;j++){
            countSort(mat,0,j);
        }
        
        return mat;
    }
    
    public void countSort(int[][]mat, int r, int c){
        int[]map = new int[101];
        
        int m = mat.length;
        int n = mat[0].length;
        
        int i =r , j = c;
        
        while(i<m && j<n){
            map[mat[i][j]]++;
            i++;
            j++;
        }
        
        i=r;
        j=c;
        
        for(int k =1;k<map.length;k++){
            while(map[k]>0){
                mat[i][j]=k;
                map[k]--;
                i++;
                j++;
            }
        }
    }
}