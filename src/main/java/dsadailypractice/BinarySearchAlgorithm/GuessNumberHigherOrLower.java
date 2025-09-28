package dsadailypractice.BinarySearchAlgorithm;

public class GuessNumberHigherOrLower {
    public static int guess(int num) {
        int myNum = 13;
        if (num > myNum) {
            return -1;
        } else if (num < myNum) {
            return 1;
        } else {
            return 0;
        }
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            int guess = guess(m);
            if (guess < 0) {
                r = m - 1;
            } else if (guess > 0) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
