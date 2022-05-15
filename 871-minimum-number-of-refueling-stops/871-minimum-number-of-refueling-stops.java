class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int refuelTime = 0, i = 0;
        
        while(true){
            //track all reachable stations' gas from current location
            while(i < stations.length && stations[i][0] <= startFuel){
                pq.offer(stations[i][1]);
                ++i;
            }   
            //already enough to get to target
            if(startFuel >= target){
                return refuelTime;
            }
            //not have enough gas with all possible stations => cannot reach target
            if(pq.isEmpty()){
                return -1;
            }
            //refuel at station which is reachable and with maximum gas
            startFuel += pq.poll();
            ++refuelTime;
        }
    
    }
}