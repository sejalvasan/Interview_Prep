//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minSwaps(n, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

 class Pair{
		int first, second;

		Pair(int a, int b){
			first = a;
			second = b;
		}
	}
	
class Solution {
    public static int minSwaps(int n, int[] A) {
        // code here
        ArrayList<Integer> v = new ArrayList<>();
        inorder(A, v, n,0);
        return min(v);
}
        
	static void inorder(int a[], ArrayList<Integer> v, int n, int index)
	{
		// if index is greater or equal to vector size
		if(index >= n)
			return;
			
		inorder(a, v, n, 2 * index + 1);
		
		// push elements in vector
		v.add(a[index]);
		
		inorder(a, v, n, 2 * index + 2);
	}
	
	public static int min(ArrayList<Integer> arr)
	{
		int n = arr.size();

		ArrayList < Pair > arrpos = new ArrayList < Pair > ();
		for (int i = 0; i < n; i++)
			arrpos.add(new Pair(arr.get(i), i));

		// Sort the array by array element values to
		// get right position of every element as the
		// elements of second array.
		arrpos.sort(new Comparator<Pair>()
		{
			@Override
			public int compare(Pair o1, Pair o2)
			{
				return o1.first - o2.first;
			}
		});

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		Boolean[] vis = new Boolean[n];
		Arrays.fill(vis, false);

		// Initialize result
		int ans = 0;

		// Traverse array elements
		for (int i = 0; i < n; i++)
		{
			// already swapped and corrected or
			// already present at correct pos
			if (vis[i] || arrpos.get(i).second == i)
				continue;

			// find out the number of node in
			// this cycle and add in ans
			int cycle_size = 0;
			int j = i;
			while (!vis[j])
			{
				vis[j] = true;

				// move to next node
				j = arrpos.get(j).second;
				cycle_size++;
			}

			// Update answer by adding current cycle.
			if(cycle_size > 0)
			{
				ans += (cycle_size - 1);
			}
		}

		// Return result
		return ans;
    }
}
