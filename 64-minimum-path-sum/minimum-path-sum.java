class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return solve(grid, 0, 0);
    }

    private int solve(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n)
            return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1)
            return grid[i][j];

        if (memo[i][j] != -1)
            return memo[i][j];

        int right = solve(grid, i, j + 1);
        int down = solve(grid, i + 1, j);

        memo[i][j] = grid[i][j] + Math.min(right, down);
        return memo[i][j];
    }
}