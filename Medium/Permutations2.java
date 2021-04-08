package Medium;
import java.util.*;
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int n: nums) {
            numbers.add(n);
        }
        permuteUnique(numbers, result, 0, nums.length);
        return result;
    }

    public void permuteUnique(List<Integer> numbers, List<List<Integer>> result, int first, int n) {
        if(first == n)
            result.add(new ArrayList<Integer>(numbers));
        for(int i = first; i < n; i++) {
            if(i != first && !canPermute(numbers, i, first))
                continue;
            Collections.swap(numbers, i, first);
            permuteUnique(numbers, result, first+1, n);
            Collections.swap(numbers, i, first);
        }
    }

    public boolean canPermute(List<Integer> numbers, int index, int first) {
        for(int i = first; i < index; i++)
            if(numbers.get(i) == numbers.get(first))
                return false;
        return true;
    }
}
