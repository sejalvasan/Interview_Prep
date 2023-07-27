//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
        	String [] str = br.readLine().trim().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	ArrayList<ArrayList<Integer>> trains = new ArrayList<>();
        	for(int i = 0; i < m; i++) {
        		str = br.readLine().trim().split(" ");
        		ArrayList<Integer> arr = new ArrayList<>();
        		for(int j = 0; j < 3; j++)
        			arr.add(Integer.parseInt(str[j]));
        		trains.add(arr);
        	}
        	Solution obj = new Solution();
        	int res = obj.maxStop(n, m, trains);
        	System.out.println(res);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        
        Collections.sort(trains, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
                return (x.get(1)-y.get(1));
           }
       });

        int[] earliestDeparture = new int[n+1];
      
        int count = 0;

        for (int i = 0; i < m; i++) {
            
            int platform = trains.get(i).get(2);
            int arrivalTime = trains.get(i).get(0);
            int departureTime = trains.get(i).get(1);
            
                if (earliestDeparture[platform] <= arrivalTime) {
                    earliestDeparture[platform] = departureTime;
                    count++;
                }

        }
        return count;
    }
}