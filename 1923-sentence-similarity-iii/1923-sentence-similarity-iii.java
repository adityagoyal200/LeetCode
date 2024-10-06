class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1 == null || sentence2 == null) {
            return false;
        }

        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");
        int sen1Len = sen1.length;
        int sen2Len = sen2.length;

        int prefix = 0;
        int suffix = 0;

        String[] shorter = sen1Len <= sen2Len ? sen1 : sen2;
        String[] longer = sen1Len > sen2Len ? sen1 : sen2;

        int shorterLen = shorter.length;
        int longerLen = longer.length;


        for (int i = 0; i < shorterLen; i++) {
            if (shorter[i].equals(longer[i])) {
                prefix++;
            } else {
                break;
            }
        }


        int j = shorterLen - 1;
        
        for (int i = longerLen - 1; j >= 0 && i >= longerLen - shorterLen; i--, j--) {
            if (shorter[j].equals(longer[i])) {
                suffix++;
            } else {
                break;
            }
        }


        return prefix + suffix >= shorterLen;
    }
}
