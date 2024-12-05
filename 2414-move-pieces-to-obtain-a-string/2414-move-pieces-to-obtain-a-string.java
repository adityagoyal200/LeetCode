class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        
        if (start.replace("_", "").equals(target.replace("_", ""))) {
            int i = 0;
            int j = 0;

            while (i < start.length() && j < target.length()) {
                while (i < start.length() && start.charAt(i) == '_') {
                    i++;
                }

                while (j < target.length() && target.charAt(j) == '_') {
                    j++;
                }

                if (i < start.length() && j < target.length() && start.charAt(i) != target.charAt(j)) {
                    return false;
                }

                if (i < start.length() && j < target.length() && start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (i < start.length() && j < target.length() && start.charAt(i) == 'R' && i > j) {
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
