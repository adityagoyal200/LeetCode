class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'a', 'b', 'c'};
        int total = (int) Math.pow(2, n - 1);

        for (int i = 0, prev = -1; i < n; i++, total /= 2) {
            for (char c : chars) {
                if (c - 'a' == prev) continue;
                if (total >= k) {
                    sb.append(c);
                    prev = c - 'a';
                    break;
                }
                k -= total;
            }
        }
        return sb.length() == n ? sb.toString() : "";
    }
}
