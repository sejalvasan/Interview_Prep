// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

// class Pair{
//     int x;
//     int y;
//     Pair(int x, int y){
//         this.x =x;
//         this.y =y;
//     }
// }
// class Solution
// {
//     static int[][]dirs = new int[][]{{1,2},{2,1},{-1,2},{2,-1},{1,-2},{-2,1}
//     ,{-1,-2},{-2,-1}};
//     public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
//     {
//         // Code here
//         //0 based indexing
//         KnightPos[0]--;
// 		KnightPos[1]--;
// 		TargetPos[0]--;
// 		TargetPos[1]--;
//         Queue<Pair> q = new LinkedList<>();
//         int steps =0;
//         q.add(new Pair(KnightPos[0],TargetPos[1]));
//         boolean[][]vis = new boolean[N][N];
//         int s1=KnightPos[0];
//         int s2 = KnightPos[1];
//         vis[s1][s2]=true;
        
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             while(size-->0){
//                 Pair rem = q.remove();
//                 if(rem.x == TargetPos[0] && rem.y == TargetPos[1])
//                 return steps;
                
//                 for(int i=0;i<8;i++){
//                     int r = rem.x+dirs[i][0];
//                     int c = rem.y+dirs[i][1];
                    
//                     if(r<0 || c<0 || r>=N || c>=N || vis[r][c]==true)
//                     continue;
                    
//                     vis[r][c]=true;
//                     q.add(new Pair(r,c));
//                 }
//             }
//                  steps++;
//         }
//         return -1;
//     }
// }

class Pair{
    int x, y;
    
    Pair(int a, int b){
        x = a;
        y = b;
    }
}

class Solution
{
    int ans;
    int dir[][] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        ans = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[N+1][N+1]; // one based indexing
        
        // BACKTRACKING SOL
        // WORKING - But took too long
        // minStepToReachTarget(KnightPos[0], KnightPos[1], TargetPos, N, vis, 0);
        
        // GRAPHS - BFS
        // Strategy: Add nodes at distance 1 the all nodes at distance 2, ..3
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0], KnightPos[1]));
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair fn = q.remove();
                if(fn.x == TargetPos[0] && fn.y == TargetPos[1]){
                    return level;
                }
                
                if(vis[fn.x][fn.y]) continue;
                
                vis[fn.x][fn.y] = true;
                
                for(int k = 0; k < 8; k++){
                    int row = fn.x + dir[k][0];
                    int col = fn.y + dir[k][1];
                    if(row < 0 || col < 0 || row > N || col > N || vis[row][col]) continue;
                    q.add(new Pair(row, col));
                }
            }
            level++; 
        }
        return -1;
    }
}