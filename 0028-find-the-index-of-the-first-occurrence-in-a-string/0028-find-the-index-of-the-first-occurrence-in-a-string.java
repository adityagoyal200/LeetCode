class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }

        int[] lps = new int[needle.length()];
        compute(needle,lps);
        int i = 0,j =0;
        //comparision needle and haystack

        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i - needle.length();
                }
            } else  if(haystack.charAt(i) != needle.charAt(j)){
                if(j > 0){
                    j = lps[j-1];
                }else {
                    i++;
                }
            }
        }

        return -1;
    }
    private void compute(String needle, int[] lps){
        int i = 1, j = 0;

        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            } 
            else if(needle.charAt(i) != needle.charAt(j)){
                if(j > 0){
                   j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

    }
}