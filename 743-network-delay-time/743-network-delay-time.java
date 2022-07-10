class Node{
    int target;
    int distance;
    
    Node(int target, int distance){
        this.target = target;
        this.distance = distance;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Set<Node>> map = new HashMap<>();
        
        for(int[]time:times){
            map.putIfAbsent(time[0],new HashSet<>());
            map.get(time[0]).add(new Node(time[1],time[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.distance - b.distance);
        HashSet<Integer> vis = new HashSet<>();
                                 
        pq.add(new Node(k,0));
        
     int totalTime =0;
        
     while(!pq.isEmpty()){
         int size = pq.size();
         
         while(size-->0){
             
             Node rem = pq.remove();
             if(vis.contains(rem.target))
                 continue;

             vis.add(rem.target);

             totalTime = Math.max(totalTime, rem.distance);

             //all nodes visited
             if(vis.size()==n)
                 return totalTime;

             if(map.containsKey(rem.target)){
                 for(Node children:map.get(rem.target)){
                     int childTime = rem.distance + children.distance;
                     pq.add(new Node(children.target, childTime));
                 }
             }

         }
     }

     return -1;
    }
}