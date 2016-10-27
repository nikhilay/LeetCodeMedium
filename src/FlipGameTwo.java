/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these
 * two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping
 * the middle "++" to become "+--+".
 */

public class FlipGameTwo {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        return canWinHelper(s.toCharArray());
    }

    private boolean canWinHelper(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == '+' && arr[i] == '+') {
                arr[i - 1] = '-';
                arr[i] = '-';

                boolean win = canWinHelper(arr);

                arr[i - 1] = '+';
                arr[i] = '+';

                if(!win){
                    return true;
                }

            }
        }
        return false;
    }
}
