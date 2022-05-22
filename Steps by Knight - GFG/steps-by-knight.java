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


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
     boolean isValid(int x, int y, int N){
		return (x >=0 && x < N && y >=0 && y < N);
	}
	
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        //to make it 0 based
        KnightPos[0]--;
		KnightPos[1]--;
		TargetPos[0]--;
		TargetPos[1]--;
		
		
		// x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
		boolean vis[][] = new boolean[N][N];
		
		Queue<ArrayList<Integer>> q = new LinkedList<>(); 
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(KnightPos[0]);
		temp.add(KnightPos[1]);
		temp.add(0);
		q.add(temp);
		
		vis[KnightPos[0]][KnightPos[1]] = true;
		
		while(!q.isEmpty())
		{
		    ArrayList<Integer> temp2 = q.poll();
			int x = temp2.get(0);
			int y = temp2.get(1);
			int steps = temp2.get(2);
			
			if(x == TargetPos[0] && y == TargetPos[1])
				return steps;
				
			for(int i=0; i<8; i++)
			{
				int n_x = x + dx[i];
				int n_y = y + dy[i];
				if(isValid(n_x, n_y, N) && !vis[n_x][n_y])
				{
				    ArrayList<Integer> temp1 = new ArrayList<>();
            		temp1.add(n_x);
            		temp1.add(n_y);
            		temp1.add(steps+1);
					q.add(temp1);
					vis[n_x][n_y] = true;
				}
			}
		}
		return -1;
    }
}