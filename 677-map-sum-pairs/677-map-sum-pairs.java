class MapSum {
    
    class TrieNode{
        TrieNode[]children = null;
        int wt=0;
        
        TrieNode(){
            children = new TrieNode[26];
        }
    }
        TrieNode root = null;

    public MapSum(){
        root = new TrieNode();
    }
    
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for(char c:key.toCharArray()){
            int idx = c-'a';
            if(curr.children[idx]==null)
                curr.children[idx]=new TrieNode();
            
            curr = curr.children[idx];
        }
        curr.wt = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            int idx = c-'a';
            if(curr.children[idx]==null)
                return 0;
            
            curr = curr.children[idx];
        }
        return dfs(curr);
    }
    
    public int dfs(TrieNode curr){
        int sum =0;
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null)
                sum+=dfs(curr.children[i]);
        }
        
        return sum + curr.wt;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */