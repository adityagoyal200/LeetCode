class Solution {
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        helper(s, 0, 0, "");
        return result;
    }

    private void helper(String s, int index, int dots, String curr) {
        if (index == s.length() && dots == 4) {
            result.add(curr.substring(0, curr.length() - 1)); 
            return;
        }

        if (dots > 4 || index >= s.length()) {
            return; 
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i <= s.length()) {
                String segment = s.substring(index, index + i);
                int value = Integer.parseInt(segment);
                if (value >= 0 && value <= 255 && (segment.equals("0") || segment.charAt(0) != '0')) {
                    helper(s, index + i, dots + 1, curr + segment + ".");
                }
            }
        }
    }
}

