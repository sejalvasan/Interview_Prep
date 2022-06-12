class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[]res = new int[n]; //edges
        int []nodes = new int[n];
        
        //making of tree/graph
        //use hashset or arraylist
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<>();
        }
        
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        helper1(graph,nodes,res,0,-1);
        helper2(graph,nodes,res,0,-1);
        
        return res;
    }
    
    public void helper1( HashSet<Integer>[] graph,int[]nodes,int[]res, int src, int par){
        
        //go to nbrs
        for(int nbr:graph[src]){
            if(nbr!=par){
            helper1(graph,nodes,res,nbr,src);
            //post
            nodes[src]+=nodes[nbr];
            res[src]+=nodes[nbr]+ res[nbr];
            }
        } 
    nodes[src]++;

    }
    
     public void helper2( HashSet<Integer>[] graph,int[]nodes,int[]res, int src, int par){
        
        //go to nbrs
        for(int nbr:graph[src]){
            if(nbr!=par){
                //pre
                res[nbr]= res[src]+ (nodes.length- nodes[nbr])- (nodes[nbr]);
            helper2(graph,nodes,res,nbr,src);
            
            }
        } 
    }
}