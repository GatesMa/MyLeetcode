class Solution {

    int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    boolean flag = existHelper(board, vis, word, 1, i, j);
                    if(flag) return flag;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, boolean[][] vis, String word, int currIndex, int i, int j) {
        if(currIndex == word.length()) return true;
        boolean flag = false;
        for(int k = 0;k <4;k++) {
            int xx = i + directs[k][0];
            int yy = j + directs[k][1];
            if(check(board, vis, xx, yy, word, currIndex)) {
                vis[xx][yy] = true;
                flag = existHelper(board, vis, word, currIndex+1, xx, yy);
                if(flag) return flag;
                vis[xx][yy] = false;
            }
        }
        return flag;
    }

    public boolean check(char[][] board,boolean[][] vis, int i, int j, String word, int currIndex) {
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && !vis[i][j] && board[i][j] == word.charAt(currIndex)) {
            return true;
        }
        return false;
    }

}
