package dsadailypractice.GreedyAlgorithm;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, ans = 0;
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            currGain += gain;
            totalGain += gain;
            if (currGain < 0) {
                currGain = 0;
                ans = i + 1;
            }
        }
        return totalGain >= 0 ? ans : -1;
    }
}
