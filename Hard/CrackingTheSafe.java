/**
There is a box protected by a password. The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.

While entering a password, the last n digits entered will automatically be matched against the correct password.

For example, assuming the correct password is "345", if you type "012345", the box will open because the correct password matches the suffix of the entered password.

Return any password of minimum length that is guaranteed to open the box at some point of entering it.

 

Example 1:

Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:

Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
 

Note:

n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.
 */

package Hard;
import java.util.*;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k, n);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++)
            res.append(0);
        Set<String> visited = new HashSet<>();
        visited.add(res.toString());
        dfs(n, k, total, res, visited);
        return res.toString();
    }
    
    public boolean dfs(int n, int k, int total, StringBuilder res, Set<String> visited) {
        if(visited.size() == total)
            return true;
        String next = res.substring(res.length() - n + 1);
        for(int i = 0; i < k; i++) {
            if(visited.add(next+i)) {
                res.append(i);
                if(dfs(n, k, total, res, visited))
                    return true;
                res.deleteCharAt(res.length() - 1);
                visited.remove(next+i);
            }
        }
        return false;
    }
}