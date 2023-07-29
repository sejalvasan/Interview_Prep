//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
      public int[] topK(int[] arr, int k) {
        // Code here
        int n = arr.length;
         Map<Integer, Integer> mp
            = new HashMap<Integer, Integer>();
 
        for (int i = 0; i < n; i++) {
 
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
  
        // Create a Priority Queue 
        // to sort based on the
        // count or on the key if the 
        // count is same
        PriorityQueue<Map.Entry<Integer, 
                                Integer>> queue
            = new PriorityQueue<>(
                (a, b)
                -> a.getValue().equals(b.getValue())
                   ? Integer.compare(b.getKey(),
                                     a.getKey())
                   : Integer.compare(b.getValue(),
                                     a.getValue()));
  
        // Insert the data from the map 
        // to the Priority Queue.
        for (Map.Entry<Integer, Integer> entry :
             mp.entrySet())
            queue.offer(entry);
  
        // Print the top k elements
        int nums[]= new int[k];
        for (int i = 0; i < k; i++) 
        {
            nums[i]=queue.poll().getKey();
        }
    return nums;
    }
}