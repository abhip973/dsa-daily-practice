package dsadailypractice.GreedyAlgorithm;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] points = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int passengers = trips[i][0];
            points[trips[i][1]] += passengers;
            points[trips[i][2]] -= passengers;
        }
        int maxCapacity = 0;
        for (int i = 0; i < 1001; i++) {
            maxCapacity += points[i];
            if (maxCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
