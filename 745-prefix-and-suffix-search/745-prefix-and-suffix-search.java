class WordFilter {

    class TrieNode {
        TrieNode[] children;
        int index;

        public TrieNode() {
            children = new TrieNode[27];
        }

        public void insert(String s, int index) {
            TrieNode it = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (it.children[idx] == null) {
                    it.children[idx] = new TrieNode();
                }
                it = it.children[idx];
                it.index = index;
            }
        }

        public int startsWith(String prefix) {
            TrieNode it = root;
            for (char c : prefix.toCharArray()) {
                int idx = c-'a';
                if(it.children[idx]==null) 
                    return -1;
                
               it = it.children[idx];
            }
            return it.index;
        }
    }

    TrieNode root;

    // apple -> {apple, e{apple, le{apple, ple{apple, pple{apple, apple{apple;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.startsWith(suffix + '{' + prefix);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */