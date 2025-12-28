package dsadailypractice.GreedyAlgorithm;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedule(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare((b[1] - b[0]), (a[1] - a[0])));
        int n = costs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2)
                ans += costs[i][0];
            else
                ans += costs[i][1];
        }
        return ans;
    }
}
