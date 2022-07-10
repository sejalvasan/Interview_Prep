// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int nums[], int n, int k)
    {
	// Your code here	
    int total = 0;
        for(int el: nums){
            total+=el;
        }

        if(total%k !=0){
            return false;
        }

        if (nums.length < k) return false;

        int subsetSum = total/k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, subsetSum);
}

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        if (k == 0) return true;
        if (curSum > subsetSum) return false;
        if (curSum == subsetSum)  {
            return canPartition(nums, visited, 0, k - 1, 0, subsetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, curSum + nums[i], subsetSum)) return true;
            visited[i] = false;
        }

        return false;
    }
}

