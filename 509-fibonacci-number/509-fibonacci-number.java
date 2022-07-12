class Solution{
public int fib(int n) {
      if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
     //dp
//         int [] arr = new int [31];
        
//         arr[0] = 0;
//         arr[1] = 1;
//         arr[2] = 1;
        
//         for(int i = 3; i < 31; i++) {
//             arr[i] = arr[i-1] + arr[i-2];
//         }
//         return arr[n];
    }
}