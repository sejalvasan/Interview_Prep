class Solution {
     int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
        HashMap<Integer , Integer> rowMap = new HashMap<>();
        HashMap<Integer , Integer> colMap = new HashMap<>();
        HashMap<Integer , Integer> diagonalOne = new HashMap<>(); // row-col
        HashMap<Integer , Integer> diagonalTwo = new HashMap<>();//row+col
        HashSet<Long> cellNo = new HashSet<>();
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
       
       for(int[] lamp :lamps){
           int row = lamp[0];
           int col=lamp[1];
           if(!cellNo.contains((long)(row*n+col))){
               turnOn(row,col,n);
           }
       }
        int[]ans = new int[queries.length];
        int i=0;
        for(int []query:queries){
            int row = query[0];
            int col=query[1];
            if(isIlluminated(row , col ,n)){
                ans[i]=1;
            }
            turnOff(row,col,n);
            i++;
        }
        return ans;
    }
    
    private void turnOn(int r , int c , int n){
        rowMap.put(r , rowMap.getOrDefault(r,0)+1);
        colMap.put(c , colMap.getOrDefault(c,0)+1);
        diagonalOne.put(r-c , diagonalOne.getOrDefault(r-c , 0)+1);
        diagonalTwo.put(r+c , diagonalTwo.getOrDefault(r+c , 0)+1);
        cellNo.add((long)(r*n+c));
        
    }
    
    private boolean isIlluminated(int r , int c , int n){
        if(rowMap.containsKey(r)|| colMap.containsKey(c)||diagonalOne.containsKey(r-c)|| diagonalTwo.containsKey(r+c) ){
           return true;
        }
        return false;
    }
    
    private void turnOff(int r , int c , int n){
        for(int []dir:dirs){
            int x = r+dir[0];
            int y= c+dir[1];
            if(x>=0 && x<n && y>=0 && y<n && cellNo.contains((long)(x*n+y))){
                cellNo.remove((long)(x*n+y));
            
            if(rowMap.containsKey(x)){
                rowMap.put(x , rowMap.get(x)-1);
                if(rowMap.get(x)==0)
                    rowMap.remove(x);
            }
            
            if(colMap.containsKey(y)){
                colMap.put(y , colMap.get(y)-1);
                if(colMap.get(y)==0)
                    colMap.remove(y);
            }
            
            if(diagonalOne.containsKey(x-y)){
                diagonalOne.put(x-y , diagonalOne.get(x-y)-1);
                if(diagonalOne.get(x-y)==0)
                    diagonalOne.remove(x-y);
            }
            if(diagonalTwo.containsKey(x+y)){
                diagonalTwo.put(x+y , diagonalTwo.get(x+y)-1);
                if(diagonalTwo.get(x+y)==0)
                    diagonalTwo.remove(x+y);
            }
        }
      }
    }
}