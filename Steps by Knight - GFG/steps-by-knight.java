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

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}
class Solution
{
    static int[][]dirs = new int[][]{{1,2},{2,1},{-1,2},{2,-1},{1,-2},{-2,1}
    ,{-1,-2},{-2,-1}};
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        //0 based indexing
        KnightPos[0]--;
		KnightPos[1]--;
		TargetPos[0]--;
		TargetPos[1]--;
        Queue<Pair> q = new LinkedList<>();
        int steps =0;
        q.add(new Pair(KnightPos[0],KnightPos[1]));
        boolean[][]vis = new boolean[N][N];
        int s1=KnightPos[0];
        int s2 = KnightPos[1];
        vis[s1][s2]=true;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                if(rem.x == TargetPos[0] && rem.y == TargetPos[1])
                return steps;
                
                for(int i=0;i<8;i++){
                    int r = rem.x+dirs[i][0];
                    int c = rem.y+dirs[i][1];
                    
                    if(r<0 || c<0 || r>=N || c>=N || vis[r][c]==true)
                    continue;
                    
                    vis[r][c]=true;
                    q.add(new Pair(r,c));
                }
            }
                 steps++;
        }
        return -1;
    }
}