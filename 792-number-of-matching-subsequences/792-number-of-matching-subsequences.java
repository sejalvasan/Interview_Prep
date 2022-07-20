class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        HashMap<Character, ArrayList<Integer>>map = new HashMap<>();
        int count = 0;
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                map.get(ch).add(i);
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch,list);
            }
        }
        
        for(String w:words){
            if(Subsequence(w,map,s))
                count++;
        }
            
        return count;
    }
           
    public boolean Subsequence(String w, HashMap<Character, ArrayList<Integer>>map, String s){
        int low =-1;
        for(int i =0;i<w.length();i++){
            char ch = w.charAt(i);
            if(map.containsKey(ch)){
                if(low==-1)
                    low = map.get(ch).get(0);
                else
                {
                    low = getIdx(low,map.get(ch));
                    if(low == -1)
                        return false;
                }
            }
            else
                return false;
            
        }
        return true;
    }
    
    public int getIdx(int low, ArrayList<Integer> list){
        int start = 0;
        int end = list.size()-1;
        int ans = -1;
        
    
        while(start<=end){
            int mid = start +(end-start)/2;
            
            if(list.get(mid)>low){
                end = mid-1;
                ans = list.get(mid);
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}