class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        
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