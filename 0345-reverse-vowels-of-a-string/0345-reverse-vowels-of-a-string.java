class Solution {
    public String reverseVowels(String s) {
        
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        
      char []arr = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(vowels.contains(arr[i]) && vowels.contains(arr[j]))
            {swap(i, j, arr);
             i++;
             j--;}
            else if(vowels.contains(arr[i]) && !vowels.contains(arr[j]))
                j--;
            else if(!vowels.contains(arr[i]) && vowels.contains(arr[j]))
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