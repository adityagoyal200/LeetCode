class Solution {
    public boolean winnerOfGame(String colors) {
        int conA = 0;
        int conB = 0;
        int len = colors.length();

        if(len < 3){
            return false;
        }

        for (int i = 0; i < len - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i + 2) == 'A') {
                conA++;
            } else if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i + 2) == 'B') {
                conB++;
            }
        }

        return conA > conB;
    }
}
