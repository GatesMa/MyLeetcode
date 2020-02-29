class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);

        
        return 2 * res[0][0] + res[0][1];
    }

    public int[][] matrixMultiply(int[][] m1, int[][] m2) {
        int[][] m = new int[m1.length][m2[0].length];
        for(int i = 0;i < m1.length;i++) {
            for(int j = 0;j < m2[0].length;j++) {
                for(int k = 0;k < m1[0].length;k++) {
                    m[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return m;
    }

    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for(int i = 0;i < m.length;i++) {
            res[i][i] = 1;
        }
        int[][] temp = m;
        for(;p != 0;p >>= 1) {
            if((p&1) != 0) res = matrixMultiply(res, temp);
            temp = matrixMultiply(temp, temp);
        }
        return res;
    }

}
