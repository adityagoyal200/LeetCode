class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int[] netShifts = new int[s.length() + 1]; 

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;
            netShifts[start] += direction;
            netShifts[end + 1] -= direction;
        }

        int currentShift = 0;
        for (int i = 0; i < s.length(); i++) {
            currentShift = (currentShift + netShifts[i]) % 26;
            if (currentShift < 0) {
                currentShift += 26; 
            }

            chars[i] = (char) ('a' + (chars[i] - 'a' + currentShift) % 26);
        }

        return new String(chars);
    }
}
