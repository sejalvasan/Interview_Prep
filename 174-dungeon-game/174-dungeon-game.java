class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n =dungeon.length;
        int m =dungeon[0].length;
        
        for(int i=n-1;i>=0;i--){
            for(int j =m-1;j>=0;j--){
                //last cell
                if(i==n-1 && j==m-1)
                    dungeon[i][j]=Math.max(1,1-dungeon[i][j]);
            
            else if(i==n-1){
                dungeon[i][j]=Math.max(1,dungeon[i][j+1]-dungeon[i][j]);
            }
            
            else if(j==m-1){
            dungeon[i][j]=Math.max(1,dungeon[i+1][j]-dungeon[i][j]);
        }
            
            else
        dungeon[i][j]=Math.max(1,Math.min(dungeon[i+1][j]-dungeon[i][j],dungeon[i][j+1]-dungeon[i][j]));
        
    }
        }
        
        return dungeon[0][0];
}
}    