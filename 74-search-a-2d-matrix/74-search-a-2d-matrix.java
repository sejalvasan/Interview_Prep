class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    int r = binaryRowSearch(matrix, target);
        if(r==-1){
            return false;
        }
        boolean isFound = binaryColSearch(matrix, r, target);
        return isFound;
    }
    
    public int  binaryRowSearch(int [][] matrix, int target){
        int lo=0;
        int hi = matrix.length-1;
        int lc = matrix[0].length -1;
        
        while(lo<=hi){
           int mid = (lo+hi)/2;
            if(target>=matrix[mid][0] && target<= matrix[mid][lc]){
                return mid;
            }
            else if(target<matrix[mid][0]){
                hi = mid-1;
            } else if(target>matrix[mid][0]){
                lo = mid+1;
            }
        }
        return -1;
    }
    public boolean binaryColSearch(int [][]matrix, int r, int target){
        
        int lo=0;
        int hi = matrix[0].length-1;
        
        while(lo<=hi){
        int mid = (lo+hi)/2;
            
            if(matrix[r][mid]==target){
                return true;
            }else if(matrix[r][mid]<target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    } 
    
}

// public boolean searchMatrix(int[][] matrix, int target) {
//         int i =0, j = matrix[0].length-1;
//         int n = matrix.length;
//         int m =  matrix[0].length-1;
//         while(i<n && j>=0){
//             if(matrix[i][j]==target)
//                 return true;
            
//             if(matrix[i][j]>target)
//                 j--;
//             else
//                 i++;
//         }
//         return false;
//     }
// }