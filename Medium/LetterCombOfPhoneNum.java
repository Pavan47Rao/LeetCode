/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"] 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


*/

package Medium;
import java.util.*;

public class LetterCombOfPhoneNum {
    Map<String, String> dict = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public void backtrack(String combo, String nextDigits) {
        if(nextDigits.length() == 0)
            result.add(combo);
        else {
            String digit = nextDigits.substring(0,1);
            String letters = dict.get(digit);
            for(int i=0;i<letters.length();i++) {
                String letter = letters.substring(i, i+1);
                backtrack(combo+letter, nextDigits.substring(1));
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
        dict.put("2","abc");
        dict.put("3","def");
        dict.put("4","ghi");
        dict.put("5","jkl");
        dict.put("6","mno");
        dict.put("7","pqrs");
        dict.put("8","tuv");
        dict.put("9","wxyz");
        if(digits.length() != 0)
            backtrack("", digits);
        return result;
    }
}
