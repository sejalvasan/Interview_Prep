
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(a==b){
                return b-a;
            }else{
                return Math.abs(b-x)-Math.abs(a-x);
            }
        });
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                if(Math.abs(pq.peek()-x)>Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}