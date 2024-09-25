class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        if (bannedWords == null || bannedWords.length == 0) {
            return false;
        }
        if (message == null || message.length == 0) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : message) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int cnt = 0;
        Set<String> banned = new HashSet<>();

        for (String bannedWord : bannedWords) {
            if (map.containsKey(bannedWord) && !banned.contains(bannedWord)) {
                cnt += map.get(bannedWord);
                banned.add(bannedWord);
            }
            if (cnt >= 2) {
                return true;
            }
        }

        return false; 
    }
}
