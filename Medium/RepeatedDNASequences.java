/**
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.
 */

package Medium;
import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A',0);
        dnaMap.put('C',1);
        dnaMap.put('G',2);
        dnaMap.put('T',3);
        
        int n = s.length();
        int[] dna = new int[n];
        for(int i=0;i<n;i++) {
            dna[i] = dnaMap.get(s.charAt(i));
        }
        
        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        
        int h = 0, l = 10, a = 4, aL = (int) Math.pow(a, l);
        for(int i=0; i < n-l+1; i++) {
            if(i > 0) {
                h = h * a - dna[i-1] * aL + dna[i+l-1]; 
            }
            else {
                for(int j=0;j<l;j++)
                    h = h * a + dna[j];
            }
            if(seen.contains(h))
                result.add(s.substring(i, i+l));
            seen.add(h);
        }
        return new ArrayList<String>(result);
    }
}
