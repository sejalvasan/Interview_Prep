class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//         String one = "";
//         for(int i =0;i<word1.length;i++)
//             one = one + word1[i];
        
//         System.out.println(one);
//           String two = "";
//         for(int i =0;i<word2.length;i++)
//             two = two + word2[i];
//       System.out.println(two);
//         if(one.length()!=two.length())
//         return false;
        
//         for(int i =0;i<two.length();i++){
//             if(one.charAt(i)!=two.charAt(i))
//                 return false;
//         }
        
//         return true;
//     }
// }
        String one = "";
        for(int i =0;i<word1.length;i++)
            one = one + word1[i];
        
          String two = "";
        for(int i =0;i<word2.length;i++)
            two = two + word2[i];
        
        if(one.equals(two))
            return true;
        
        return false;
        
    }
}