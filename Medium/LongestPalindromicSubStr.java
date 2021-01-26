/**
 * Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Example 3:

Input: s = "a"
Output: "a"

Example 4:

Input: s = "ac"
Output: "a" 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
 */

package Medium;

public class LongestPalindromicSubStr {
    public String longestPalindrome(String s) {
        int n = s.length();
		  int palindromeBeginsAt = 0; //index where the longest palindrome begins
		  int max_len = 1;//length of the longest palindrome
		  boolean palindrome[][] = new boolean[n][n]; //boolean table to store palindrome truth
		  
        if(n<1)
            return s;
		  //Trivial case: single letter palindromes
		  for (int i = 0; i < n; i++) {
			  palindrome[i][i] = true;
		  }
		  
		  //Finding palindromes of two characters.
		  for (int i = 0; i < n-1; i++) {
		    if (s.charAt(i) == s.charAt(i+1)) {
		      palindrome[i][i+1] = true;
		      palindromeBeginsAt = i;
		      max_len = 2;
		    }
		  }
		  
		  //Finding palindromes of length 3 to n and saving the longest
		  for (int curr_len = 3; curr_len <= n; curr_len++) {
		    for (int i = 0; i < n-curr_len+1; i++) {
		      int j = i+curr_len-1;
		      if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
		    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
		      {
		    	palindrome[i][j] = true; 
		        palindromeBeginsAt = i;
		        max_len = curr_len;
		      }
		    }
		  }
		  return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
    }
}
