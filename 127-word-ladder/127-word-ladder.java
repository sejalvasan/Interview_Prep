class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        
        for(String word : wordList){
            set.add(word);
        }
        
        if(!set.contains(endWord))
            return 0;
        
        q.offer(beginWord);
        int level = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                
                String currWord = q.poll();
                char [] wordChars = currWord.toCharArray();
                
                for(int j =0;j<wordChars.length;j++){
                    char originalChar = wordChars[j];
                    for(char c ='a';c<='z';c++){
                        if(originalChar==c) continue;
                        wordChars[j]=c;
                        String newWord = String.valueOf(wordChars);
                        if(newWord.equals(endWord)) return level+1;
                        if(set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChars[j]= originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}