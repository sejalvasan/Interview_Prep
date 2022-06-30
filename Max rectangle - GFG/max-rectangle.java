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
        int heights []= new int [m];
        for(int i =0;i<m;i++){
            heights[i]=M[0][i];
        }
        int area = largestAreaRectangle(heights);
        
        for(int i=1;i<n;i++){
            for(int j =0;j<m;j++){
                if(M[i][j]==1){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }
            area = Math.max(area, largestAreaRectangle(heights));
        }
            return area;
    }
    
    static int largestAreaRectangle(int [] heights){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea =0;
        for(int i =0;i<=heights.length;i++){
            
            int val =i ==heights.length?0:heights[i];
            while(st.peek()!=-1 && heights[st.peek()]>=val){
            int rm =i;
            int h = heights[st.pop()];
            int lm = st.peek();
            maxArea = Math.max(maxArea, h*(rm-lm-1));
        }
        st.push(i);
        }
        return maxArea;
    }
    
}