//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Pair{
    int first;
    int sec;
    
    Pair(int first, int sec){
        this.first = first;
        this.sec = sec;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
     Pair[]x = new Pair[n];
        
        for(int i=0;i<n;i++){
           x[i]= new Pair(start[i], end[i]);
        }
        
        Arrays.sort(x,(a,b)->a.sec-b.sec);
        
        int last = Integer.MIN_VALUE, count = 0;
        
        for(int i =0; i<n; i++){
            if(x[i].first>last){
                last =x[i].sec;
                count++;
            }            
        }
        
        return count;
    }
}