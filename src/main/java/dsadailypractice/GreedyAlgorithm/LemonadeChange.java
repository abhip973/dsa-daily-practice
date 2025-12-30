package dsadailypractice.GreedyAlgorithm;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] change = {0, 0};
        for (int bill : bills) {
            if (bill == 5) {
                change[0]++;
            } else if (bill == 10) {
                change[1]++;
                change[0]--;
            } else {
                if (change[1] > 0) {
                    change[1]--;
                    change[0]--;
                } else {
                    change[0] = change[0] - 3;
                }
            }
            if (change[0] < 0)
                return false;
        }
        return true;
    }
}
