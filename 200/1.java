class Solution {

    private int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int len1 = grid.length;
        int len2 = grid[0].length;
        boolean[][] vis = new boolean[len1][len2];
        int ans = 0;
        for (int i = 0;i < len1;i++) {
            for (int j = 0;j < len2;j++) {
                if (check(grid, i, j, vis)) {
                    solutions(grid, vis, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void solutions(char[][] grid, boolean[][] vis, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || vis[x][y] || grid[x][y] == '0') {
            return;
        }
        vis[x][y] = true;
        for (int i = 0;i < 4;i++) {
            int xx = x + dis[i][0];
            int yy = y + dis[i][1];
            solutions(grid, vis, xx, yy);
        }
    }

    public Boolean check(char[][] grid, int x, int y, boolean[][] vis) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !vis[x][y] && grid[x][y] == '1') {
            return true;
        }
        return false;
    }

}
