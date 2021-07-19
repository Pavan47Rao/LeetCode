/**
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
The student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Return true if the student is eligible for an attendance award, or false otherwise.

 

Example 1:

Input: s = "PPALLP"
Output: true
Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
Example 2:

Input: s = "PPALLL"
Output: false
Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 

Constraints:

1 <= s.length <= 1000
s[i] is either 'A', 'L', or 'P'.
 */

package Easy;

public class StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {
        int noOfAbsentDays = s.charAt(0) == 'A' ? 1 : 0;
        int noOfConsecutiveLeaves = s.charAt(0) == 'L' ? 1 : 0;
        char prevDayStatus = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char curDayStatus = s.charAt(i);
            if(curDayStatus == 'A') {
                noOfAbsentDays++;
                if(noOfAbsentDays > 1)
                    return false;
            }
            else if(curDayStatus == 'L') {
                if(curDayStatus == prevDayStatus) {
                    noOfConsecutiveLeaves++;
                    if(noOfConsecutiveLeaves > 2)
                        return false;
                }
                else
                    noOfConsecutiveLeaves = 1;
            }
            prevDayStatus = curDayStatus;
        }
        return true;
    }
}

// 1 line regex solution: !s.matches(".*(A.*A|LLL).*");
