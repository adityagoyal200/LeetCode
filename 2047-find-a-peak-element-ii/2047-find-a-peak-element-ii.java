class Solution {
    public int[] findPeakGrid(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = mat[0].length - 1;
        int rowLen = mat.length;
        int colLen = mat[0].length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int max = 0;
            
            for (int i = 0; i < rowLen; i++) {
                if (mat[i][mid] > mat[max][mid]) {
                    max = i;
                }
            }

            int left = (mid - 1 >= 0) ? mat[max][mid - 1] : -1;
            int right = (mid + 1 < colLen) ? mat[max][mid + 1] : -1;

            if (mat[max][mid] > left && mat[max][mid] > right) {
                return new int[]{max, mid};
            } else if (mat[max][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
