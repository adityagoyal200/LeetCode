class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();

        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            if (i == n || j == n) {
                return i == j;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if ((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}
