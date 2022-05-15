// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        int[]count = new int[256];
        
        for(int i=0;i<S.length();i++){
            count[S.charAt(i)]++;
        }
        
        int odd=0;
        
        for(int i=0;i<count.length;i++){
            if(count[i]%2==1)
            odd++;
            
            if(odd>1)
            return 0;
        }
        return 1;
    }
}