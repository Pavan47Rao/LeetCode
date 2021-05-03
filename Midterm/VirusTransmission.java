/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */

package Midterm;

public class VirusTransmission {

    public static void main(String[] args) {

        char[][] matrix = {
            {'0','0','X','0'},
            {'X','0','X','X'},
            {'X','0','0','0'}};
        char[][] matrix2 = {
            {'0','X'},
            {'X','0'}};
        char[][] matrix3 = {
            {'0','0'},
            {'0','0'}};

        System.out.println(getResult(matrix, 5));
        System.out.println(getResult(matrix2, 2));
        System.out.println(getResult(matrix3, 3));

    }

    public static String getResult(char[][] body, int maxTime){

        return canTrasmitVirus(0,0,body,maxTime, 0) ? "can infect" : "cannot infect";
    }

    public static boolean canTrasmitVirus(int i, int j, char[][] body, int maximumTime, int currentTime){

        if(i == body.length - 1 && j == body[0].length - 1){
            return true;
        }

        if(currentTime == maximumTime) return false;

        if(i + 1 < body.length && body[i+1][j] != 'X'){
            if(canTrasmitVirus(i+1, j, body, maximumTime, currentTime+1)){
                return true;
            }
        }

        if(i - 1 > 0 && body[i-1][j] != 'X'){
            if(canTrasmitVirus(i-1, j, body, maximumTime, currentTime+1)){
                return true;
            }
        }

        if(j + 1 < body[0].length && body[i][j+1] != 'X'){
            if(canTrasmitVirus(i, j+1, body, maximumTime, currentTime+1)){
                return true;
            }
        }

        if(j - 1 > 0 && body[i][j-1] != 'X'){
            if(canTrasmitVirus(i, j-1, body, maximumTime, currentTime+1)){
                return true;
            }
        }

        return false;
    }
   
}
