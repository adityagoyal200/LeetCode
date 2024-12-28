public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        } 
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                rows[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j >= 1 && i < s.length(); j--) {
                rows[j].append(s.charAt(i++));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}