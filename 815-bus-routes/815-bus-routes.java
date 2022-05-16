class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer> >map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j =0;j<routes[i].length;j++){ // as each bus can have diff number of bus stops
                int stopno = routes[i][j];
                ArrayList<Integer> busno = map.getOrDefault(stopno, new ArrayList<Integer>());
                busno.add(i);
                map.put(stopno,busno);
            }
        }
        
        int level =0;
        HashSet<Integer> busStop = new HashSet<>();
        HashSet<Integer> busvis = new HashSet<>();
        q.add(source);
        busStop.add(source);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                int rem = q.remove();
                if(rem==target)
                    return level;
                
                ArrayList<Integer> bus = map.get(rem);
                
                for(int buss:bus){
                    if(busvis.contains(buss))
                        continue;
                    int[]arr=routes[buss];
                    for(int bs:arr){
                        if(busStop.contains(bs))
                            continue;
                        q.add(bs);
                        busStop.add(bs);
                    }
                    busvis.add(buss);
                }
            }
            level++;
        }
        return -1;
    }
}