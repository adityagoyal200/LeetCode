class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        if (words == null || words.length == 0) return new int[0];

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        int[] prefixSum = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            if (vowelsSet.contains(first) && vowelsSet.contains(last)) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }

        return result;
    }
}
