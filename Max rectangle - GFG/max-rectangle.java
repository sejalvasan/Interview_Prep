//{ Driver Code Starts
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
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int[]arr = new int[m];
        for(int i =0;i<m;i++){
            arr[i] = M[0][i];
        }
        
        int area = largestRect(arr);
        
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                if(M[i][j]==1){
                    arr[j]+=1;
                }else
                arr[j]=0;
            }
            area = Math.max(area, largestRect(arr));
        }
        
        return area;
    }
    
    public int largestRect(int []arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = 0;
        
        for(int i =0;i<=n;i++){
            int val = i==n?0:arr[i];
            
            while(st.peek()!=-1 && arr[st.peek()]>=val){
                int rm = i;
                int h = arr[st.pop()];
                int lm = st.peek();
                area = Math.max(area, h*(rm-lm-1));
            }
            st.push(i);
        }
        return area;
    }
}