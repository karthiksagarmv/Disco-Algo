
class Solution {
    
    public static int palStartIndex = 0, palEndIndex =0;
    
    public boolean isPalindrome(String s, int start, int end)
    {
                
        while(start<end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        
        return true;
    }
    
    public void palindromeLength(String s, int start, int end)
    {
        if(start < 0 || end >= s.length())
            return;
        
        int curPalLength = palEndIndex - palStartIndex + 1;
        
        if(end - start + 1 > curPalLength)
        {    
            if(isPalindrome(s,start,end)){
                palEndIndex = end;
                palStartIndex = start;
            }
            else{
                palindromeLength(s,start+1,end);
                palindromeLength(s,start,end-1);
            }
        }   
    }
    
    
    public String longestPalindrome(String s) {
        palStartIndex = 0;
        palEndIndex = 0;
        palindromeLength(s,0,s.length() -1);
        return s.substring(palStartIndex, palEndIndex + 1);
    }
}
