class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int rows = arr.length;
        if (rows == 0) return false;
        
        int cols = arr[0].length;
        if (cols == 0) return false;

        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }
}