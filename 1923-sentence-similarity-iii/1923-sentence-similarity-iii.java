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
        int len1 = sen1.length;
        int len2 = sen2.length;

        if (len1 > len2) {
            String[] temp = sen1;
            sen1 = sen2;
            sen2 = temp;
            len1 = sen1.length;
            len2 = sen2.length;
        }

        int prefix = 0;
        while (prefix < len1 && sen1[prefix].equals(sen2[prefix])) {
            prefix++;
        }

        int suffix = 0;
        while (suffix < len1 - prefix && sen1[len1 - 1 - suffix].equals(sen2[len2 - 1 - suffix])) {
            suffix++;
        }

        return prefix + suffix >= len1;
    }
}
