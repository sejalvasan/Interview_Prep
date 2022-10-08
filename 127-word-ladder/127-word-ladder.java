class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
       
        for(String word : wordList){
            set.add(word);
        }
                
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String curr = q.remove();
                char[]currWord = curr.toCharArray();
                
                for(int i = 0;i<currWord.length;i++){
                    char og = currWord[i];
                    for(char c ='a';c<='z';c++){
                        currWord[i]=c;
                        String newWord = String.valueOf(currWord);
                        if(newWord.equals(endWord)) return level+1;
                        if(set.contains(newWord)){
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    currWord[i]=og;
                }
            }
            level++;
        }
        
        return 0;
    }
}