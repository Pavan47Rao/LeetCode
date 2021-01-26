/**
 * Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
 */

package Easy;

public class CountPrimes {
    public int countPrimes(int n) {
        //         int primeCount=0;
        //         Boolean[] primes = new Boolean[n];
        //         Arrays.fill(primes, Boolean.TRUE);
        //         for(int i=2 ; i<primes.length ; i++) {
        //             if(primes[i]) {
        //                 for(int j=2 ; j<primes.length ; j++) {
        //                     if(i*j < n)
        //                     primes[i*j] = Boolean.FALSE;
        //                 }
        //             }
        //         }
                
        //         for (int i = 2; i < primes.length; i++) {
        //             if (primes[i]) {
        //                 primeCount++;
        //             }
        //         }
        //         return primeCount;
                int count=0;
                if(n<2)
                    return count;
                for(int i=2;i<n;i++)
                {
                    int flag=0;
                    int sqr=(int)Math.sqrt(i);
                    for(int j=2;j<=sqr;j++)
                    {
                        if(i%j==0)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)
                        count++;
                }
                return count;
            }
}
