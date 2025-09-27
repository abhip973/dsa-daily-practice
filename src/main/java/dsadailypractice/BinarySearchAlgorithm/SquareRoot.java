package dsadailypractice.BinarySearchAlgorithm;

public class SquareRoot {
    public int sqrt(int x) {
        if (x < 2) return x;
        int l = 2;
        int r = x / 2;
        int m = 0;
        while (l <= r) {
            m = (r + l) / 2;
            long sq = (long) m * m;
            if (sq > x) {
                r = m - 1;
            } else if (sq < x) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return r;
    }
}
