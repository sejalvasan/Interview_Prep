class Trie {
   
    public TrieNode root;
    
    private class TrieNode{
        TrieNode[]children =null;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    public Trie() {
     root = new TrieNode();   
    }
    
    public void insert(String word) {
        TrieNode it = root;
        
        for(char c:word.toCharArray()){
            int idx = c-'a';
            if(it.children[idx]==null){
                it.children[idx]=new TrieNode();
            }
            it=it.children[idx];
        }
        it.isWord=true;
    }
    
    public boolean search(String word) {
         TrieNode it = root;
        
        for(char c:word.toCharArray()){
            int idx = c-'a';
            if(it.children[idx]==null){
               return false;
            }else{
            it=it.children[idx];
        }
       }
        return it.isWord;
    }
    
    public boolean startsWith(String prefix) {
       TrieNode it = root;
        
        for(char c:prefix.toCharArray()){
            int idx = c-'a';
            if(it.children[idx]==null){
               return false;
            }else{
            it=it.children[idx];
        }
       }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */