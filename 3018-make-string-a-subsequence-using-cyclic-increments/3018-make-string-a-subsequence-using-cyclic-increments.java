class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        if (m > n) {
            return false;
        }

        int i = 0, j = 0;
        
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j) || 
                (str1.charAt(i) + 1 - 'a') % 26 == (str2.charAt(j) - 'a') % 26) {
                j++; 
            }
            i++; 
        }

        return j == m;
    }
}
