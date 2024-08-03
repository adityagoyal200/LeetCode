class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        if (enemyEnergies == null || enemyEnergies.length == 0) {
            return 0;
        }

        Arrays.sort(enemyEnergies);

        if (currentEnergy < enemyEnergies[0]) {
            return 0;
        }

        long totalP = 0;
        long currP = 0;

        int i = 0;
        int j = enemyEnergies.length - 1;

        while (i <= j) {
            if (currentEnergy >= enemyEnergies[i]) {
                totalP += currentEnergy / enemyEnergies[i];
                currP +=  currentEnergy / enemyEnergies[i];
                currentEnergy %= enemyEnergies[i];
            } else {
                if (currP > 0) {
                    currentEnergy += enemyEnergies[j];
                    currP--;
                    j--;
                } else {
                    break;
                }
            }
        }

        return totalP;
    }
}
