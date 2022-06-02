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
        //solved via bfs
        if(node == null)
            return node;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node();
        newNode.val = node.val;
            map.put(node,newNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
              int size=q.size();
            while(size-->0){
                Node rem = q.poll();
                for(Node child: rem.neighbors){
                    if(!map.containsKey(child)){
                          Node newChild = new Node();
                           newChild.val = child.val;
                        map.put(child,newChild);
                        q.add(child);
                    }
                    Node newList = map.get(rem); //getting 2'
                    newList.neighbors.add(map.get(child));
                }
            }
        }
        return map.get(node); //1'
        
    }
}