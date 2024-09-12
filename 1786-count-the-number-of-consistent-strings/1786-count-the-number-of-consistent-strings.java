class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        for(char c: allowed.toCharArray()){
            set.add(c);
        }

        int count = 0;
        for(String s: words){
            int i = 0;
            count++;
            while(i < s.length()){
                if(!set.contains(s.charAt(i))){
                    count--;
                    break;
                }
                i++;
            }
        }

        return count;
    }
}