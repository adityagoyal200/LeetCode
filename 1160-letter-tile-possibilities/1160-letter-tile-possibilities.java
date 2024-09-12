class Solution {
    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        helper(tiles, new StringBuilder(), set, used);
        
        return set.size();
    }

    private void helper(String tiles, StringBuilder sb, Set<String> set, boolean[] used) {
        if (sb.length() > 0) {
            set.add(sb.toString());
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(tiles.charAt(i));
            helper(tiles, sb, set, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
