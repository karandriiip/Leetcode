class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        boolean[] rowZero = new boolean[m]; // Keep track of rows to zero
        boolean[] colZero = new boolean[n]; // Keep track of columns to zero

        // 1. Find zeroes and mark rows/cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        // 2. Set zeroes based on marked rows/cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}