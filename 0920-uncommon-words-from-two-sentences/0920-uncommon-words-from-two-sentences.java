import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        if(s1.length() == 0 && s2.length() == 0) {
            return new String[]{};
        }

        String[] word1 = s1.split("\\s+");
        String[] word2 = s2.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : word1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : word2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }
}
