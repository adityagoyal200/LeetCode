class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        long sum = 0;

        int[] pse = findPse(arr);
        int[] nse = findNse(arr);

        for (int i = 0; i < arr.length; i++) {
            long totalSub = (long) (i - pse[i]) * (nse[i] - i) % mod;
            sum = (sum + totalSub * arr[i] % mod) % mod;
        }

        return (int) sum;
    }

    private int[] findPse(int[] arr) {
        Stack<int[]> st = new Stack<>();
        int[] pse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek()[0] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek()[1];
            st.push(new int[]{arr[i], i});
        }

        return pse;
    }

    private int[] findNse(int[] arr) {
        Stack<int[]> st = new Stack<>();
        int[] nse = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek()[0] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek()[1];
            st.push(new int[]{arr[i], i});
        }

        return nse;
    }
}
