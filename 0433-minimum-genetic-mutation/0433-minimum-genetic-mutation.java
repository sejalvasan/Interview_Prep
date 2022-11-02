class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bankSet = new HashSet<>();
        char choices[] = {'A','C','G','T'};  
        for(String s:bank)
            bankSet.add(s);
        
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        seen.add(start);
        q.add(start);
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                String curr = q.poll();
                
                if(curr.equals(end)) return level;
                
                char[]cur = curr.toCharArray();
                
                for(int i =0;i<8;i++){
                    char og = cur[i];
                    
                    for(int k =0;k<4;k++){
                        if(og!=choices[k]){
                            cur[i]=choices[k];
                            String newStr = new String(cur);
                            if(!seen.contains(newStr) && bankSet.contains(newStr)){
                                q.add(newStr);
                                seen.add(newStr);
                            }
                        }
                    }
                    cur[i]=og;
                }
            }
            level++;
        }
        
        return -1;
    }
}