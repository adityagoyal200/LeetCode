class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, 
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rowCount = new HashMap<>();
        Map<Integer, Integer> colCount = new HashMap<>();
        Map<Integer, Integer> diagCount = new HashMap<>();
        Map<Integer, Integer> antiDiagCount = new HashMap<>();
        Set<String> lampSet = new HashSet<>();

        for (int[] lamp : lamps) {
            int row = lamp[0], col = lamp[1];
            String lampKey = row + "," + col;
            if (lampSet.contains(lampKey)) continue;
            lampSet.add(lampKey);
            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
            colCount.put(col, colCount.getOrDefault(col, 0) + 1);
            diagCount.put(row - col, diagCount.getOrDefault(row - col, 0) + 1);
            antiDiagCount.put(row + col, antiDiagCount.getOrDefault(row + col, 0) + 1);
        }

        int[] result = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int row = query[0], col = query[1];
            result[index++] = (rowCount.getOrDefault(row, 0) > 0 || 
                               colCount.getOrDefault(col, 0) > 0 || 
                               diagCount.getOrDefault(row - col, 0) > 0 || 
                               antiDiagCount.getOrDefault(row + col, 0) > 0) ? 1 : 0;

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0], newCol = col + dir[1];
                String lampKey = newRow + "," + newCol;
                if (lampSet.contains(lampKey)) {
                    lampSet.remove(lampKey);
                    rowCount.put(newRow, rowCount.get(newRow) - 1);
                    colCount.put(newCol, colCount.get(newCol) - 1);
                    diagCount.put(newRow - newCol, diagCount.get(newRow - newCol) - 1);
                    antiDiagCount.put(newRow + newCol, antiDiagCount.get(newRow + newCol) - 1);
                }
            }
        }
        return result;
    }
}
