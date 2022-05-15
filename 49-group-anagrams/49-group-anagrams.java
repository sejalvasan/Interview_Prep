class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i =0;i<strs.length;i++){
           String word=strs[i];
            char[]sorted = word.toCharArray();
            Arrays.sort(sorted);
            String newWord = new String(sorted);
            
            if(map.containsKey(newWord))
                map.get(newWord).add(word);
            
            else{
                 List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord,words);
            }
        }
        
 
	for (List values : map.values())
		ans.add(values);

	return ans;
    }
}