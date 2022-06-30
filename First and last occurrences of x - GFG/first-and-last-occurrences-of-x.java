// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
         ArrayList<Long> ans = new ArrayList<>();
        Arrays.sort(arr);
       long start = findAns(arr,n,x,true);
       long end = findAns(arr,n,x,false);
       
       ans.add(start);
       ans.add(end);
       return ans;
    }
   long findAns(long[]arr, int n,int x, boolean flag){
        int lo =0, hi =n-1,mid;
        long pot =-1;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            
            if(arr[mid]>x)
            hi = mid-1;
            else if(arr[mid]<x)
            lo=mid+1;
            else{
                pot = mid;
                if(flag)
                hi = mid-1;
                else lo = mid+1;
            }
        }
        return pot;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
  // } Driver Code Ends