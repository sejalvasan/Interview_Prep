// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String endWord, 
    String[] wordList)
    {
        // Code here
        //bfs approach
        HashSet<String> set = new HashSet<>();
        int level =1;
        Queue<String> q = new LinkedList<>();
        
        for(String word:wordList)
        set.add(word);
        
        if(!set.contains(endWord))
        return 0;
        
        q.add(startWord);
        set.remove(startWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String word = q.remove();
                char[]currWord = word.toCharArray();
                for(int j =0;j<currWord.length;j++){
                    char original = currWord[j];
                    for(char c='a';c<='z';c++){
                        currWord[j]=c;
                        if(endWord.equals(String.valueOf(currWord)))
                        return level+1;
                        
                        if(set.contains(String.valueOf(currWord)))
                        {
                            q.add(String.valueOf(currWord));
                            set.remove(String.valueOf(currWord));
                        }
                    }
                    currWord[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}