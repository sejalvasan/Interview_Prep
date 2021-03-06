class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Set<String> dup = new HashSet<>();
        List<String> wordList = new ArrayList<>(wordSet);
        
        for(int i=0;i<wordList.size();i++){
            for(int j=0;j<wordList.size();j++){
                if(i!=j){
                    if(wordList.get(i).endsWith(wordList.get(j))){
                        dup.add(wordList.get(j));
                    }
                }
            }
        }
        
        int count =0;
        for(String word:wordList){
            if(!dup.contains(word)){
                count += word.length()+1;
            }
        }
        return count;
    }
}