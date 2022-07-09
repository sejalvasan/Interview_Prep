class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<routes.length;i++){  //for bus no.
            for(int j=0;j<routes[i].length;j++){  //for bus stops of each bus
                int stopNo = routes[i][j];
             ArrayList<Integer> busNo = map.getOrDefault(stopNo,new ArrayList<Integer>());
                busNo.add(i);
                map.put(stopNo,busNo);
            }
        }
        
        int level =0;
        HashSet<Integer> busVis = new HashSet<>();
        HashSet<Integer> busStopVis = new HashSet<>();
        
        q.add(source);
        busStopVis.add(source);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int rem = q.remove();
                
                if(rem == target)
                    return level;
                
                ArrayList<Integer> busNumbers = map.get(rem);
                
                for(int bus:busNumbers){
                    if(busVis.contains(bus))
                        continue;
                    
                    busVis.add(bus);
                    
                    int[]buses = routes[bus];
                    
                    for(int buss: buses){
                        if(busStopVis.contains(buss))
                            continue;
                        q.add(buss);
                        busStopVis.add(buss);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}


