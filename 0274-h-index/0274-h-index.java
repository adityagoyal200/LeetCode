import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int h = n - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] < h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return n - low;
    }
}
