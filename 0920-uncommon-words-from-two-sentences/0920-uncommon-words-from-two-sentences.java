class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        if(s1.length() == 0 && s2.length() == 0) {
            return new String[]{};
        }

        String[] word1 = s1.split("\\s+");
        String[] word2 = s2.split("\\s+");

        Set<String> set = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        // Add words from first sentence
        for(String s: word1) {
            if(set.contains(s)) {
                set.remove(s);
                duplicates.add(s);  // Track duplicates
            } else if (!duplicates.contains(s)) {
                set.add(s);
            }
        }

        for(String s: word2) {
            if(set.contains(s)) {
                set.remove(s);
                duplicates.add(s);  // Track duplicates
            } else if (!duplicates.contains(s)) {
                set.add(s);
            }
        }

        String[] result = new String[set.size()];
        int index = 0;
        for(String s: set) {
            result[index++] = s;
        }

        return result;
    }
}
