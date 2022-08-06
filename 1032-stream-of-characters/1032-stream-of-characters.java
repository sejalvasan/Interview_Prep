class StreamChecker {

    class TrieNode{
        TrieNode children[];
        boolean isLeaf;
        
        TrieNode(){
            children = new TrieNode[26];
            isLeaf = false;
        }
    }
    
    TrieNode root = null;
    
    public StreamChecker(String[] words) {
    root = new TrieNode();
    queStr = new StringBuilder();

        for(String w: words){
            addWord(w);
        }
    }
    
    public void addWord(String s){
        TrieNode it = root;
        
        for(int i =s.length()-1;i>=0;i--){
           char c = s.charAt(i);
            int idx = c-'a';
            if(it.children[idx]==null)
                it.children[idx]=new TrieNode();
            
            it = it.children[idx];
        }
        
        it.isLeaf=true;
    }
    
    StringBuilder queStr;
    
    public boolean query(char letter) {
        queStr.append(letter);
     return search(queStr.toString());   
    }
    
    public boolean search(String word){
        TrieNode it = root;
        
        for(int i =word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            int idx = c-'a';
           if(it.children[idx]!=null){
               it=it.children[idx];
               if(it.isLeaf)
                   return true;
           }else
               
            return false;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */