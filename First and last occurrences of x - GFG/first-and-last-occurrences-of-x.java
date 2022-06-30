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
     ArrayList<Long>ans = new ArrayList<>();
        Arrays.sort(arr);

        long start = search(arr, x,true,n);
        long end = search(arr, x,false,n);
        ans.add(start);
        ans.add(end);
        return ans;
    }
    
    int search(long arr[],int x, boolean findStart,int n){
        int start =0;
        int end = n-1;
        int pot =-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(x<arr[mid]){
                end = mid-1;
            }else if(x>arr[mid]){
                start=mid+1;
            }else{
                pot = mid;
                if(findStart){
                    end=mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
       return pot;
    }
    
}



// { Driver Code Starts.

// Driver class

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