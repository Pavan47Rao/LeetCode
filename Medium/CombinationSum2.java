/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

**/


package Medium;
import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        dfs(0, target, candidates, ans, res);
        return res;
    }
    private void dfs(int index, int target, int[] candidates, List<Integer> ans, List<List<Integer>> res){
        if(target == 0) {
            res.add(new LinkedList<>(ans));
            return;
        }
        if(target < 0 || index == candidates.length) return;
        for(int i = index; i < candidates.length; i++){
            ans.add(candidates[i]);
            dfs(i+1, target - candidates[i], candidates, ans, res);
            ans.remove(ans.size()-1);
            while(i+1 < candidates.length && candidates[i] == candidates[i+1]) 
                i++;
        }
    }
}
