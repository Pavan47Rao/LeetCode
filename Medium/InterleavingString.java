/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 

Follow up: Could you solve it using only O(s2.length) additional memory space?
 */

package Medium;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                memo[i][j] = -1;
        return isInterleave(s1, 0, s2, 0, s3, 0, memo);
    }
    
    public boolean isInterleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if(i == s1.length())
            return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length())
            return s1.substring(i).equals(s3.substring(k));
        if(memo[i][j] >= 0)
            return memo[i][j] == 1 ? true : false;
        boolean ans = false;
        if(s1.charAt(i) == s3.charAt(k) && isInterleave(s1, i+1, s2, j, s3, k+1, memo) || s2.charAt(j) == s3.charAt(k) && isInterleave(s1, i, s2, j+1, s3, k+1, memo))
            ans = true;
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
