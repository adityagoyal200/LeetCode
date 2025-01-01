class Solution {
    public int maxScore(String inputStr) {
        int totalOnes = 0, zerosCount = 0, onesCount = 0, bestScore = Integer.MIN_VALUE;

        for (char ch : inputStr.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        for (int i = 0; i < inputStr.length() - 1; i++) {
            if (inputStr.charAt(i) == '0'){ 
                zerosCount++;
            } else { 
                onesCount++;
            }
            
            bestScore = Math.max(bestScore, zerosCount + (totalOnes - onesCount));
        }

        return bestScore;
    }
}
