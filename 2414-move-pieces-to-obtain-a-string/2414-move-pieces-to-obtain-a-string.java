class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        if (start.replace("_", "").equals(target.replace("_", ""))) {
            int i = 0;
            int j = 0;

            while (i < n && j < n) {
                while (i < n && start.charAt(i) == '_') {
                    i++;
                }

                while (j < n && target.charAt(j) == '_') {
                    j++;
                }

                if(i == n || j==n) return i==n && j==n;

                if (i < n && j < n && start.charAt(i) != target.charAt(j)) {
                    return false;
                }

                if (i < n && j < n && start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (i < n && j < n && start.charAt(i) == 'R' && i > j) {
                    return false;
                }

                i++;
                j++;
            }
            
            return true;
        }
        
        return false;
    }
}
