class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y =y;
    }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int oldColor = image[sr][sc];
     int[][]dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        if(oldColor == newColor)
            return image;
        
        while(!q.isEmpty()){
            Pair rem = q.remove();
            
            if(image[rem.x][rem.y]==oldColor)
                image[rem.x][rem.y]=newColor;
            
            for(int i=0;i<4;i++){
                int r = rem.x + dirs[i][0];
                int c = rem.y + dirs[i][1];
                
                if(r<0 || c<0 || r>= image.length || c>= image[0].length || image[r][c]!=oldColor)
                    continue;
                
                q.add(new Pair(r,c));
            }
        }
        return image;
    }
}