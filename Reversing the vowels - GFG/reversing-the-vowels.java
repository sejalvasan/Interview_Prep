//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String modify (String s)
    {
        
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
      char []arr = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(vowels.contains(arr[i]) && vowels.contains(arr[j]))
            {swap(i, j, arr);
             i++;
             j--;}
            else if(vowels.contains(arr[i]))
                j--;
            else if(!vowels.contains(arr[i]))
                i++;
            else{
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }
    
    public static void swap(int left, int right, char[]arr){
        char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
    }
}