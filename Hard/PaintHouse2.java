/**
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.

 

Example 1:

Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Example 2:

Input: costs = [[1,3],[2,4]]
Output: 5
 

Constraints:

costs.length == n
costs[i].length == k
1 <= n <= 100
1 <= k <= 20
1 <= costs[i][j] <= 20
 

Follow up: Could you solve it in O(nk) runtime?
 */

package Hard;
public class PaintHouse2{
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        for(int house = 1; house < n; house++) {
            for(int color = 0; color < k; color++) {
                int minPrice = Integer.MAX_VALUE;
                for(int prevColor = 0; prevColor < k; prevColor++) {
                    if(color == prevColor)
                        continue;
                    minPrice = Math.min(minPrice, costs[house-1][prevColor]);
                }
                costs[house][color] += minPrice;
            }
        }
        int minPrice = Integer.MAX_VALUE;
        for(int c: costs[n-1])
            minPrice = Math.min(minPrice, c);
        return minPrice;
    }
}

/**
Above approach has O(n*k*k) complexity, the following has O(n*k)

for(int house = 1; house < n; house++) {
    int minColor = -1, secondMinColor = -1;
    for(int color = 0; color < k; color++) {
        int cost = costs[house-1][color];
        if(minColor == -1 || cost < costs[house-1][minColor]) {
            secondMinColor = minColor;
            minColor = color;
        }
        else if(secondMinColor == -1 || cost < costs[house-1][secondMinColor])
            secondMinColor = color;
    } 
    for(int color = 0; color < k; color++) {
        if(color == minColor)
            costs[house][color] += costs[house-1][secondMinColor];
        else
            costs[house][color] += costs[house-1][minColor];
    }
}
int minPrice = Integer.MAX_VALUE;
for(int c: costs[n-1])
    minPrice = Math.min(minPrice, c);
return minPrice;
 */