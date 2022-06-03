class WordDictionary {

     class TrieNode{
        TrieNode[]children = null;
        boolean isLeaf;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
     TrieNode root;
    
    public WordDictionary() {
    root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        TrieNode it = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int idx = c-'a';
            if(it.children[idx]==null)
                it.children[idx]=new TrieNode();
            
            it=it.children[idx];
        }
        it.isLeaf = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
        }
    
    public boolean searchHelper(String word, int idx, TrieNode root){
        if(word.length()==idx)
            return root.isLeaf;
        
        char c = word.charAt(idx);
        if(c=='.'){
            for(int i=0;i<26;i++){
        if(root.children[i]!=null && searchHelper(word,idx+1, root.children[i]))
                return true;
        }
    }
            
    else{
            int index = c-'a';
            
            if(root.children[index]!=null && searchHelper(word,idx+1, root.children[index]))
                return true;
        }
        return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */