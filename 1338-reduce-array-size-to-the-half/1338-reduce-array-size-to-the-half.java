class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i =0 ;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list,Collections.reverseOrder());
        
        int count = 0;
        int totEle = arr.length;
        int i =0;
        
        while(totEle>arr.length/2){
            totEle = totEle - list.get(i);
            i++;
            count++;
        }
        
        return count;
    }
}