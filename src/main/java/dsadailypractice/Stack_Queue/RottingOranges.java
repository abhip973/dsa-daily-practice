package dsadailypractice.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        //1. Add already rotten oranges to the queue

        int rows = grid.length;
        int column = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        //2. Convert fresh oranges to rotten in all 4 directions
        int maxMinutes = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] - 1 >= 0 && grid[top[0] - 1][top[1]] == 1) {
                grid[top[0] - 1][top[1]] = 2;
                queue.offer(new int[]{top[0] - 1, top[1], top[2] + 1});
            }
            if (top[1] - 1 >= 0 && grid[top[0]][top[1] - 1] == 1) {
                grid[top[0]][top[1] - 1] = 2;
                queue.offer(new int[]{top[0], top[1] - 1, top[2] + 1});
            }
            if (top[0] + 1 < rows && grid[top[0] + 1][top[1]] == 1) {
                grid[top[0] + 1][top[1]] = 2;
                queue.offer(new int[]{top[0] + 1, top[1], top[2] + 1});
            }
            if (top[1] + 1 < column && grid[top[0]][top[1] + 1] == 1) {
                grid[top[0]][top[1] + 1] = 2;
                queue.offer(new int[]{top[0], top[1] + 1, top[2] + 1});
            }
            maxMinutes = Math.max(maxMinutes, top[2]);
        }

        //3. Check if any fresh orange remaining
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxMinutes;
    }
}
