/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

package Easy;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        while(p1 >= 0 || p2 >=0) {
            int x1 = p1 >= 0 ? num1.charAt(p1)-'0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2)-'0' : 0;
            int val = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            p1--;
            p2--;
            sb.append(val);
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
