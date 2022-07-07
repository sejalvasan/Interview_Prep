/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node newNode = new Node(); 
        newNode.val = node.val;
        
        map.put(node,newNode); // 1->1'
        q.add(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
              Node rem = q.remove();
                for(Node child:rem.neighbors){
                    if(!map.containsKey(child)){
                        Node newNodes = new Node();
                        newNodes.val = child.val;
                        map.put(child,newNodes);
                        q.add(child);
                    }
                    Node newList = map.get(rem); //getting 1'
                    newList.neighbors.add(map.get(child)); //1'->2'
                }
            }
        }
        return map.get(node);
    }
}