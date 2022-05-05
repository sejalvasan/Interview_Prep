// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int n1,int n2,int n3, int[] stack1, int[] stack2, int[] stack3) {
           int sum1 = 0, sum2 = 0, sum3 = 0;
       
      // Finding the initial sum of stack1.
      for (int i=0; i < n1; i++)
          sum1 += stack1[i];
      
      // Finding the initial sum of stack2.
      for (int i=0; i < n2; i++)
          sum2 += stack2[i];
      
      // Finding the initial sum of stack3.
      for (int i=0; i < n3; i++)
          sum3 += stack3[i];
      
      // As given in question, first element is top
      // of stack..
      int top1 =0, top2 = 0, top3 = 0;
      int ans = 0;
      while (true)
      {
          // If any stack is empty
          if (top1 == n1 || top2 == n2 || top3 == n3)
             return 0;
      
          // If sum of all three stack are equal.
          if (sum1 == sum2 && sum2 == sum3)
             return sum1;
          
          // Finding the stack with maximum sum and
          // removing its top element.
          if (sum1 >= sum2 && sum1 >= sum3)
             sum1 -= stack1[top1++];
          else if (sum2 >= sum1 && sum2 >= sum3)
             sum2 -= stack2[top2++];
          else if (sum3 >= sum2 && sum3 >= sum1)
             sum3 -= stack3[top3++];
       }
    }
}
        
