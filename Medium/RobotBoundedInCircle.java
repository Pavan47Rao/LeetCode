/**
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.
 */

package Medium;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, index = 0;
        for(char direction: instructions.toCharArray()) {
            if(direction == 'L')
                index = (index + 3) % 4;
            else if(direction == 'R')
                index = (index + 1) % 4;
            else {
                x = directions[index][0];
                y = directions[index][1];
            }
        }
        return (x == 0 && y ==0) || index != 0;
    }
}

// limit cycle trajectory v/s diverging trajectory
// above solution is based on 2 conditions
// 1. if robot returns to 0,0 after 1 cycle it's limit cycle trajectory
// 2. if robot doesn't face north (index != 0) at the end of first cycle it's limit cycle trajectory
// index: 0 - N, 1 - E, 2 - S, 3 - W
// if directions is R index will be (index + 1) % 4; modulus because facing W, the consequent R should lead it to N
// if directions is L index can be (index - 1) % 4, but this has to deal with negative values
// hence concept of '1 left = 3 right' is used => (index + 3) % 4;