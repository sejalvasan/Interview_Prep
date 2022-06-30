// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int[]heights = new int[m];
        for(int i =0;i<m;i++){
            heights[i]=M[0][i];
        }
        int maxArea =histogramArea(heights,m);
        for(int i =1;i<n;i++){
            for(int j =0;j<m;j++){
                if(M[i][j]==1)
                heights[j]++;
                else
                heights[j]=0;
            }
            maxArea = Math.max(maxArea,histogramArea(heights,m));
        }
        return maxArea;
       
    }
    
    public int histogramArea(int[]heights, int n){
        int area =0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int i =0;i<=n;i++){
            int val = i==n?0:heights[i];
            
            while(st.peek()!=-1 && heights[st.peek()]>=val){
                int rm =i;
                int h = heights[st.pop()];
                int lm = st.peek();
                area = Math.max(area,(rm-lm-1)*h);
            }
            st.push(i);
        }
        return area;
    }
    
}