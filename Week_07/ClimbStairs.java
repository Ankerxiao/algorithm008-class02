class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int pre = 2;
        int curr = 3;
        int i = 4;
        while (i <= n) {
            int temp = curr;class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
            curr = pre + curr;
            pre = temp;
            i++;
        }
        return curr;
    }
}