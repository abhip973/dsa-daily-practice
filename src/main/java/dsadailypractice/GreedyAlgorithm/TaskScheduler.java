package dsadailypractice.GreedyAlgorithm;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < tasks.length; i++) {
            ++arr[tasks[i] - 'A'];
            maxFreq = Math.max(maxFreq, arr[tasks[i] - 'A']);
        }
        int taskWithMaxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == maxFreq)
                taskWithMaxFreq++;
        }
        int cycles = (n + 1) * (maxFreq - 1) + taskWithMaxFreq;
        return Math.max(cycles, tasks.length);
    }
}
