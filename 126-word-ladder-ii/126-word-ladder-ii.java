class Solution {
    List<List<String>>  res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Map<String,Integer> dist = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    String beginWord;
    Set<String> S = new HashSet<>();
    
    public List<List<String>> findLadders(String _beginWord, String endWord, List<String> wordList) {
        beginWord = _beginWord;
        S.addAll(wordList);
        if(!S.contains(endWord)) return res;
        
        //do bfs -> build graph
        dist.put(beginWord,0);
        q.offer(beginWord);
        while(!q.isEmpty()){
            String t = q.poll();
            for(int i = 0; i < t.length(); i++){
                char[] str = t.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    if(str[i] != c){
                        str[i] = c;
                        String nextWord = new String(str);
                        if(S.contains(nextWord) && !dist.containsKey(nextWord)){
                            //end put the word into map
                            dist.put(nextWord, dist.get(t) + 1);
                            if(nextWord.equals(endWord)) break;
                            q.offer(nextWord);
                        }
                    }
                }
            }
        }
        //finished bfs
        //check the if we have the res
        if(!dist.containsKey(endWord)) return res;
        //we have res, find all path from endWord
        path.add(endWord);
        dfs(endWord);
        return res;
    }
    
    void dfs(String u){
        if(u.equals(beginWord)){
            List<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            res.add(tmp);
        }else{
            for(int i = 0; i < u.length(); i++){
                char[] str = u.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    if(str[i] != c){
                        str[i] = c;
                        String lastWord = new String(str);
                        if(dist.containsKey(lastWord) && dist.get(lastWord) +1 == dist.get(u)){
                            //make sure it's a sub path of shorest path
                            path.add(lastWord);
                            dfs(lastWord);
                            path.remove(path.size() - 1);
                        }
                    }
                }
            }
        }
    }
}