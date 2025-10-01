package dsadailypractice.BinarySearchAlgorithm;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean isBadVersion(int n) {
        int firstBadVersion = 4;
        return n >= 4;
    }
}
