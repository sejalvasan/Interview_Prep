// { Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> spiral = new ArrayList<>();
        int maxc=c-1;
        int maxr=r-1;
        int minc=0;
        int minr=0;
        int cnt=0;
        int total = r*c;
        
        while(cnt<total){
            for(int i=minr,j=minc;j<=maxc && cnt<total;j++){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            minr++;
            
             for(int i=minr,j=maxc;i<=maxr && cnt<total;i++){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            maxc--;
            
             for(int i=maxr,j=maxc;j>=minc && cnt<total;j--){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            maxr--;
            
             for(int i=maxr,j=minc;i>=minr && cnt<total;i--){
                spiral.add(matrix[i][j]);
                cnt++;
            }
            
            minc++;
        }   
     return spiral;
    }
}
