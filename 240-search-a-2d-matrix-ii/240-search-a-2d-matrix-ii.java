class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        boolean flag = false;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i =0;
        int j = m-1;

        while(i<n && j>=0){
                if(target>matrix[i][j])
                    i++;
                else if(target<matrix[i][j])
                    j--;
                else
                    return true;
        }
        
        return false;
    }
}