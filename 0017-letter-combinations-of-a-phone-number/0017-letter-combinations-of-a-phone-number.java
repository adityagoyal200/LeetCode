class Solution {
    HashMap<Integer, List<String>> map;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        map = new HashMap<>();

        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        helper(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void helper(String digits, int start, StringBuilder sb, List<String> result) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }

        List<String> list = map.get(digits.charAt(start) - '0');
        for (String s : list) {
            sb.append(s);
            helper(digits, start + 1, sb, result);
            sb.setLength(sb.length() - 1);
        }

    }
}