
class Solution {        
    class Pair implements Comparable<Pair> {
        int val;
        int gap;
        
        Pair(int val, int gap) {
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair o) {
            if(this.gap == o.gap) {
                return this.val - o.val;
            }
            else  {
                return this.gap - o.gap;
            }
        }
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        
        while(idx < k) {
            int gap = Math.abs(x - arr[idx]);
            pq.add(new Pair(arr[idx], gap));
            idx++;
        }
        
        while(idx < arr.length) {
            int gap = Math.abs(x - arr[idx]);
            if(pq.peek().gap > gap) {
                pq.remove();
                pq.add(new Pair(arr[idx], gap));
            }
            idx++;
        }
        
        List<Integer> ans = new ArrayList<>();
        while(pq.size() > 0) {
            ans.add(pq.remove().val);
        }
        
        Collections.sort(ans);   
        
        return ans;
    }
}