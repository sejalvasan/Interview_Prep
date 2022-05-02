// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
       if(n==1)
       return true;
       HashSet<Integer> set = new HashSet<>();
       int max =Integer.MIN_VALUE;
       int min =Integer.MAX_VALUE;
       for(int i =0;i<n;i++){
           set.add(arr[i]);
           max=Math.max(arr[i],max);
           min=Math.min(arr[i],min);
       }
       
       int d = (max-min)/(n-1);
       
       for(int i=0;i<n;i++){
           int ele=min+i*d;
           if(set.contains(ele)==false)
           return false;
       }
       return true;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}



  // } Driver Code Ends