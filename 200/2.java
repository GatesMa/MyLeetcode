// 2ms
class Solution {

    private int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int len1 = grid.length;
        int len2 = grid[0].length;
        int ans = 0;
        for (int i = 0;i < len1;i++) {
            for (int j = 0;j < len2;j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0;i < 4;i++) {
            int xx = x + dis[i][0];
            int yy = y + dis[i][1];
            dfs(grid, xx, yy);
        }
    }

}
