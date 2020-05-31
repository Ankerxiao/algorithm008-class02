class Solution {
    public int minPathSum(int[][] grid) {
        int col = grid[0].length;
        int[] dist = new int[col];
        for (int i = 1; i < col; i++) dist[i] = Integer.MAX_VALUE;
        for (int[] row: grid) {
            for (int i = 0; i < col; i++) {
                if (i == 0) {
                    dist[i] += row[i];
                } else {
                    dist[i] = row[i]  + Math.min(dist[i], dist[i - 1]);
                }
            }
        }
        return dist[col - 1];
    }
}